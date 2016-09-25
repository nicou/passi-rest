/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fi.softala.ttl.model.Group;
import fi.softala.ttl.model.Instructor;
import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;

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

	public Student getStudent(String username) {
		Student student = new Student();
		String sql1 = "SELECT o.username, o.opi_etu, o.opi_suku, o.opi_email, k.koulu FROM opi AS o "
				+ "JOIN koulu AS k ON o.koulu_id = k.koulu_id WHERE o.username = ?";
		student = jdbcTemplate.query(sql1, new Object[] {username}, new ResultSetExtractor<Student>() {
			 
	        @Override
	        public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
	            if (rs.next()) {
	                Student student = new Student();
	                student.setUsername(rs.getString("username"));
	                student.setFirstname(rs.getString("opi_etu"));
	                student.setLastname(rs.getString("opi_suku"));
	                student.setEmail(rs.getString("opi_email"));
	                student.setSchool(rs.getString("koulu"));
	                return student;
	            }
	            return null;
	        }
	    });
		if (student == null) {
			return null;
		}		
		String sql2 = "SELECT ryh.ryhma_tunnus, ryh.ryhma_nimi, ope.username, ope.ope_etu, "
				+ "ope.ope_suku, ope.ope_email, kou.koulu FROM ryhma_opi AS opi "
				+ "JOIN ryhma AS ryh ON opi.ryhma_tunnus = ryh.ryhma_tunnus "
				+ "JOIN ryhma_ope AS rop ON rop.ryhma_tunnus = ryh.ryhma_tunnus "
				+ "JOIN ope AS ope ON rop.username = ope.username "
				+ "JOIN koulu AS kou ON ope.koulu_id = kou.koulu_id "
				+ "WHERE opi.username = ?";
		ArrayList<Group> groups = new ArrayList<>();
		groups = (ArrayList<Group>) jdbcTemplate.query(sql2, new Object[] {username}, new RowMapper<Group>() {
			
			@Override
			public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
				Group group = new Group();
				group.setGroupID(rs.getString("ryhma_tunnus"));
				group.setGroupName(rs.getString("ryhma_nimi"));
				Instructor instructor = new Instructor();
				instructor.setUsername(rs.getString("username"));
				instructor.setFirstanme(rs.getString("ope_etu"));
				instructor.setLastname(rs.getString("ope_suku"));
				instructor.setEmail(rs.getString("ope_email"));
				instructor.setSchool(rs.getString("koulu"));
				group.setInstructor(instructor);
				return group;
			}
		});
		student.setGroups(groups);
		return student;
	}

	public Worksheet getWorksheet(String groupID, String username) {

		return null;
	}

	/*
	 * public boolean addGroup(Group group) { final String sql =
	 * "INSERT INTO ryhma (ryhma_tunnus, ryhma_nimi) VALUES (?, ?) ON DUPLICATE KEY UPDATE ryhma_nimi=?"
	 * ; try { jdbcTemplate.update(sql, new Object[] {group.getGroupID(),
	 * group.getGroupName(), group.getGroupName()}); } catch (Exception e) {
	 * return false; } return true; }
	 * 
	 * public boolean deleteGroup(String groupID) { final String sql =
	 * "DELETE FROM ryhma WHERE ryhma_tunnus = ?"; try {
	 * jdbcTemplate.update(sql, new Object[] {groupID}); } catch (Exception e) {
	 * return false; } return true; }
	 * 
	 * public boolean addStudent(Student student, String groupID) { final String
	 * sql1 = "INSERT INTO user (username, password) VALUES (?, ?)"; final
	 * String sql2 =
	 * "INSERT INTO opi (username, opi_etu, opi_suku, opi_koulu, opi_email) VALUES (?, ?, ?, ?, ?)"
	 * ; final String sql3 =
	 * "INSERT INTO ryhma_opi (ryhma_tunnus, username) VALUES (?, ?)"; try {
	 * jdbcTemplate.update(sql1, new Object[] {student.getUsername(),
	 * student.getPassword()}); jdbcTemplate.update(sql2, new Object[]
	 * {student.getUsername(), student.getFirstname(), student.getLastname(),
	 * student.getSchool(), student.getEmail()}); jdbcTemplate.update(sql3, new
	 * Object[] {groupID, student.getUsername()}); } catch (Exception e) {
	 * return false; } return true; }
	 * 
	 * public List<Group> getGroups() { final String sql1 =
	 * "SELECT ryhma_tunnus, ryhma_nimi FROM ryhma"; final String sql2 =
	 * "SELECT COUNT(*) FROM ryhma_opi WHERE ryhma_tunnus = ?"; RowMapper<Group>
	 * mapper = new GroupRowMapper(); List<Group> groups =
	 * jdbcTemplate.query(sql1, mapper); for (Group group : groups) {
	 * group.setNumGroupMembers(jdbcTemplate.queryForObject(sql2, new Object[]
	 * {group.getGroupID()}, Integer.class)); } return groups; }
	 * 
	 * public List<Student> getGroupStudents(String groupID) { final String sql
	 * =
	 * "SELECT username, opi_etu, opi_suku, opi_koulu, opi_email FROM opi WHERE username IN "
	 * + "(SELECT username from ryhma_opi WHERE ryhma_tunnus = ?)";
	 * RowMapper<Student> mapper = new StudentRowMapper(); List<Student>
	 * groupStudents = jdbcTemplate.query(sql, new Object[] {groupID}, mapper);
	 * return groupStudents; }
	 */
}
