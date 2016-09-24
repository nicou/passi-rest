/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import fi.softala.ttl.model.Student;

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
		final String sql = "SELECT username, opi_etu, opi_suku, opi_koulu, opi_email FROM opi WHERE username = ?";
		return jdbcTemplate.query(sql, new Object[] {username}, new ResultSetExtractor<Student>() {
			 
	        @Override
	        public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
	            if (rs.next()) {
	                Student student = new Student();
	                student.setUsername(rs.getString("username"));
	                student.setFirstname(rs.getString("opi_etu"));
	                student.setLastname(rs.getString("opi_suku"));
	                student.setSchool(rs.getString("opi_koulu"));
	                student.setEmail(rs.getString("opi_email"));
	                return student;
	            }
	            return null;
	        }
	    });
	}
	
	/*
	public boolean addGroup(Group group) {
		final String sql = "INSERT INTO ryhma (ryhma_tunnus, ryhma_nimi) VALUES (?, ?) ON DUPLICATE KEY UPDATE ryhma_nimi=?";
		try {
			jdbcTemplate.update(sql, new Object[] {group.getGroupID(), group.getGroupName(), group.getGroupName()});
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteGroup(String groupID) {
		final String sql = "DELETE FROM ryhma WHERE ryhma_tunnus = ?";
		try {
			jdbcTemplate.update(sql, new Object[] {groupID});
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean addStudent(Student student, String groupID) {
		final String sql1 = "INSERT INTO user (username, password) VALUES (?, ?)";		
		final String sql2 = "INSERT INTO opi (username, opi_etu, opi_suku, opi_koulu, opi_email) VALUES (?, ?, ?, ?, ?)";		
		final String sql3 = "INSERT INTO ryhma_opi (ryhma_tunnus, username) VALUES (?, ?)";
		try {
			jdbcTemplate.update(sql1, new Object[] {student.getUsername(), student.getPassword()});
			jdbcTemplate.update(sql2, new Object[] {student.getUsername(), student.getFirstname(), student.getLastname(), 
				student.getSchool(), student.getEmail()});
			jdbcTemplate.update(sql3, new Object[] {groupID, student.getUsername()});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<Group> getGroups() {
		final String sql1 = "SELECT ryhma_tunnus, ryhma_nimi FROM ryhma";
		final String sql2 = "SELECT COUNT(*) FROM ryhma_opi WHERE ryhma_tunnus = ?";
		RowMapper<Group> mapper = new GroupRowMapper();
		List<Group> groups = jdbcTemplate.query(sql1, mapper);
		for (Group group : groups) {
			group.setNumGroupMembers(jdbcTemplate.queryForObject(sql2, new Object[] {group.getGroupID()}, Integer.class));
		}
		return groups;
	}
	
	public List<Student> getGroupStudents(String groupID) {
		final String sql = "SELECT username, opi_etu, opi_suku, opi_koulu, opi_email FROM opi WHERE username IN "
				+ "(SELECT username from ryhma_opi WHERE ryhma_tunnus = ?)";
		RowMapper<Student> mapper = new StudentRowMapper();
		List<Student> groupStudents = jdbcTemplate.query(sql, new Object[] {groupID}, mapper);
		return groupStudents;
	}
	*/
}
