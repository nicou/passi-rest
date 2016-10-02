package fi.softala.ttl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.ttl.model.Member;

public class StudentRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setUsername(rs.getString("username"));
		member.setFirstname(rs.getString("opi_etu"));
		member.setLastname(rs.getString("opi_suku"));
		member.setSchool(rs.getString("opi_koulu"));
		member.setEmail(rs.getString("opi_email"));
		return member;
	}
}