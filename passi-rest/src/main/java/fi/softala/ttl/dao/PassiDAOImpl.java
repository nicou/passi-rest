package fi.softala.ttl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import fi.softala.ttl.model.Option;
import fi.softala.ttl.model.Answerpoint;
import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.AuthUser;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.Group;
import fi.softala.ttl.model.User;
import fi.softala.ttl.model.Waypoint;
import fi.softala.ttl.model.Worksheet;

/**
 * @author Mika Ropponen | mika.ropponen@gmail.com
 */
@Component
public class PassiDAOImpl implements PassiDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	// Find and return user with all related data
	public User findUser(String username) {
		final String SQL1 = "SELECT user_id, username, firstname, lastname, email, phone FROM users WHERE username = ?";
		User user = jdbcTemplate.query(SQL1, new Object[] { username }, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					User user = new User();
					user.setUserID(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					return user;
				}
				return null;
			}
		});
		
		if (user == null) {
			return null;
		}
		
		final String SQL2 = "SELECT groups.group_id, groups.group_name FROM groups "
				+ "JOIN members ON members.group_id = groups.group_id "
				+ "JOIN users ON members.user_id = users.user_id " + "WHERE users.user_id = ?";
		List<Group> groups = jdbcTemplate.query(SQL2, new Object[] { user.getUserID() }, new RowMapper<Group>() {

			@Override
			public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
				Group group = new Group();
				group.setGroupID(rs.getString("group_id"));
				group.setGroupName(rs.getString("group_name"));
				return group;
			}
		});
		
		user.setGroups(groups);
		
		final String SQL3 = "SELECT users.user_id, users.firstname, users.lastname, users.email, users.phone FROM users "
				+ "JOIN members ON members.user_id = users.user_id "
				+ "JOIN user_role ON user_role.user_id = users.user_id "
				+ "WHERE user_role.role_id = 2 AND members.group_id = ?";
		
		for (Group group : user.getGroups()) {
			List<User> instructors = jdbcTemplate.query(SQL3, new Object[] { group.getGroupID() },
					new RowMapper<User>() {

						@Override
						public User mapRow(ResultSet rs, int rowNum) throws SQLException {
							User user = new User();
							user.setUserID(rs.getInt("user_id"));
							user.setFirstname(rs.getString("firstname"));
							user.setLastname(rs.getString("lastname"));
							user.setEmail(rs.getString("email"));
							user.setPhone(rs.getString("phone"));
							return user;
						}
					});
			group.setGroupInstructors(instructors);
		}
		return user;
	}

	// Get worksheets by group ID
	public List<Category> getWorksheets(int groupID) {

		final String SQL1 = "SELECT categories.category_id, categories.category_name FROM categories";

		List<Category> categories = jdbcTemplate.query(SQL1, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
				category.setCategoryID(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				return category;
			}
		});

		final String SQL2 = "SELECT worksheets.worksheet_id, worksheets.header, "
				+ "worksheets.preface, worksheets.planning FROM worksheets "
				+ "JOIN distros ON distros.worksheet_id = worksheets.worksheet_id "
				+ "JOIN categories ON worksheets.category_id = categories.category_id "
				+ "WHERE distros.group_id = ? AND categories.category_id = ?";

		for (Category category : categories) {

			List<Worksheet> worksheets = new ArrayList<>();
			worksheets = jdbcTemplate.query(SQL2, new Object[] { groupID, category.getCategoryID() },
					new RowMapper<Worksheet>() {

						@Override
						public Worksheet mapRow(ResultSet rs, int rowNum) throws SQLException {
							Worksheet worksheet = new Worksheet();
							worksheet.setWorksheetID(rs.getInt("worksheet_id"));
							worksheet.setWorksheetHeader(rs.getString("header"));
							worksheet.setWorksheetPreface(rs.getString("preface"));
							worksheet.setWorksheetPlanning(rs.getString("planning"));
							return worksheet;
						}
					});

			final String SQL3 = "SELECT waypoint_id, task, photo_enabled FROM waypoints WHERE worksheet_id = ?";

			List<Waypoint> waypoints = new ArrayList<>();
			for (Worksheet worksheet : worksheets) {
				waypoints = jdbcTemplate.query(SQL3, new Object[] { worksheet.getWorksheetID() },
						new RowMapper<Waypoint>() {

							@Override
							public Waypoint mapRow(ResultSet rs, int rowNum) throws SQLException {
								Waypoint waypoint = new Waypoint();
								waypoint.setWaypointID(rs.getInt("waypoint_id"));
								waypoint.setWaypointTask(rs.getString("task"));
								waypoint.setWaypointPhotoEnabled(rs.getBoolean("photo_enabled"));
								return waypoint;
							}
						});
				worksheet.setWorksheetWaypoints(waypoints);
			}

			final String SQL4 = "SELECT option_id, option_text FROM options WHERE waypoint_id = ?";

			List<Option> options = null;
			for (Worksheet worksheet : worksheets) {
				for (Waypoint waypoint : worksheet.getWorksheetWaypoints()) {
					options = jdbcTemplate.query(SQL4, new Object[] { waypoint.getWaypointID() },
							new RowMapper<Option>() {

								@Override
								public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
									Option option = new Option();
									option.setOptionID(rs.getInt("option_id"));
									option.setOptionText(rs.getString("option_text"));
									return option;
								}
							});
					waypoint.setWaypointOptions(options);
				}
			}
			category.setCategoryWorksheets((ArrayList<Worksheet>) worksheets);
		}
		return categories;
	}

	// Check if user has already answered to the worksheet
	public boolean isAnswerExist(int worksheetID, int userID) {
		final String SQL = "SELECT EXISTS (SELECT 1 FROM answersheets WHERE worksheet_id = ? AND user_id = ?)";
		int exists = jdbcTemplate.queryForObject(SQL, new Object[] { worksheetID, userID }, Integer.class);
		if (exists == 1) {
			return true;
		}
		return false;
	}
	
	// Delete answer
	public boolean deleteAnswer(int worksheetID, int userID) {
		DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
		try {
			// Delete related waypoints
			final String SQL1 = "DELETE FROM answerpoints WHERE answersheet_id = (SELECT answersheet_id FROM answersheets WHERE worksheet_id = ? AND user_id = ?)";
			jdbcTemplate.update(SQL1, new Object[] { worksheetID, userID });
			// Delete related answer
			final String SQL2 = "DELETE FROM answersheets WHERE worksheet_id = ? AND user_id = ?";
			jdbcTemplate.update(SQL2, new Object[] { worksheetID, userID });
			// Commit transactions
			platformTransactionManager.commit(status);
		} catch (Exception e) {
			platformTransactionManager.rollback(status);
			return false;
		}
		return true;
	}

	// Save user answer
	public boolean saveAnswer(Answersheet answersheet) {
		
		final String SQL1 = "INSERT INTO answersheets (answersheet_id, planning, instructor_comment, timestamp, worksheet_id, group_id, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		final String SQL2 = "INSERT INTO answerpoints (answerpoint_id, answer_text, instructor_comment, image_url, answersheet_id, waypoint_id, option_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {

				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(SQL1, new String[] { "answersheet_id" });
					ps.setInt(1, Types.NULL);
					ps.setString(2, answersheet.getPlanning());
					ps.setString(3, answersheet.getInstructorComment());
					ps.setTimestamp(4, answersheet.getTimestamp());
					ps.setInt(5, answersheet.getWorksheetID());
					ps.setInt(6, answersheet.getGroupID());
					ps.setInt(7, answersheet.getUserID());
					return ps;
				}
			}, keyHolder);

			final int ID = keyHolder.getKey().intValue();
			answersheet.setAnswersheetID(ID);

			jdbcTemplate.batchUpdate(SQL2, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Answerpoint answerpoint = answersheet.getAnswerpoints().get(i);
					ps.setInt(1, Types.NULL);
					ps.setString(2, answerpoint.getAnswerText());
					ps.setString(3, answerpoint.getInstructorComment());
					ps.setString(4, answerpoint.getImageURL());
					ps.setInt(5, ID);
					ps.setInt(6, answerpoint.getWaypointID());
					ps.setInt(7, answerpoint.getOptionID());
				}

				@Override
				public int getBatchSize() {
					return answersheet.getAnswerpoints().size();
				}
			});
			
			platformTransactionManager.commit(status);
			
		} catch (Exception e) {
			
			platformTransactionManager.rollback(status);
			return false;
		}
		
		return true;
	}

	public Answersheet getAnswer(int worksheetID, int groupID, int userID) {

		final String SQL1 = "SELECT * FROM answersheets WHERE worksheet_id = ? AND group_id = ? AND user_id = ?";
		final String SQL2 = "SELECT * FROM answerpoints "
				+ "JOIN options ON answerpoints.option_id = options.option_id " + "WHERE answersheet_id = ?";

		Answersheet answersheet = null;

		try {
			answersheet = jdbcTemplate.queryForObject(SQL1, new Object[] { worksheetID, groupID, userID },
					new RowMapper<Answersheet>() {

						@Override
						public Answersheet mapRow(ResultSet rs, int rowNum) throws SQLException {
							Answersheet answersheet = new Answersheet();
							answersheet.setAnswersheetID(rs.getInt("answersheet_id"));
							answersheet.setPlanning(rs.getString("planning"));
							answersheet.setInstructorComment(rs.getString("instructor_comment"));
							answersheet.setTimestamp(rs.getTimestamp("timestamp"));
							answersheet.setWorksheetID(rs.getInt("worksheet_id"));
							answersheet.setGroupID(rs.getInt("group_id"));
							answersheet.setUserID(rs.getInt("user_id"));
							return answersheet;
						}
					});
		} catch (Exception e) {
			return null;
		}

		List<Answerpoint> answerpoints = jdbcTemplate.query(SQL2, new Object[] { answersheet.getAnswersheetID() },
				new RowMapper<Answerpoint>() {

					@Override
					public Answerpoint mapRow(ResultSet rs, int rowNum) throws SQLException {
						Answerpoint answerpoint = new Answerpoint();
						answerpoint.setAnswerpointID(rs.getInt("answerpoint_id"));
						answerpoint.setAnswerText(rs.getString("answer_text"));
						answerpoint.setInstructorComment(rs.getString("instructor_comment"));
						answerpoint.setInstructorRating(rs.getInt("instructor_rating"));
						answerpoint.setImageURL(rs.getString("image_url"));
						answerpoint.setAnswersheetID(rs.getInt("answersheet_id"));
						answerpoint.setWaypointID(rs.getInt("waypoint_id"));
						answerpoint.setOptionID(rs.getInt("option_id"));
						answerpoint.setOptionText(rs.getString("option_text"));
						return answerpoint;
					}

				});

		answersheet.setAnswerpoints((ArrayList<Answerpoint>) answerpoints);

		return answersheet;
	}

	// Get all instructor users for basic authentication
	@Override
	public List<AuthUser> getAuthUsers() {
		final String SQL = "SELECT username, password FROM users "
				+ "JOIN user_role ON users.user_id = user_role.user_id "
				+ "WHERE role_id = 1";
		List<AuthUser> authUsers = jdbcTemplate.query(SQL, new RowMapper<AuthUser>() {

			@Override
			public AuthUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				AuthUser authUser = new AuthUser();
				authUser.setUsername(rs.getString("username"));
				authUser.setPassword(rs.getString("password"));
				return authUser;
			}
		});
		return authUsers;
	}

	@Override
	public boolean isGroupExist(String key) {
		final String SQL = "SELECT EXISTS (SELECT 1 FROM groups WHERE group_key = ?)";
		int exists = jdbcTemplate.queryForObject(SQL, new Object[] { key }, Integer.class);
		if (exists == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean joinUserIntoGroup(String key, int userID) {
		final String SQL1 = "SELECT group_id FROM groups WHERE group_key = ?";
		final String SQL2 = "INSERT INTO members (user_id, group_id) VALUES (?, ?)";
		try {
			int groupID = jdbcTemplate.queryForObject(SQL1, new Object[] { key }, Integer.class);
			jdbcTemplate.update(SQL2, new Object[] { userID, groupID });
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
