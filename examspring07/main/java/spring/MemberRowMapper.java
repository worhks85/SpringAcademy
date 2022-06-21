package spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<Member>{
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(
				rs.getString("EMAIL"), 
				rs.getString("PASSWORD"), 
				rs.getString("NAME"));
		member.setId(rs.getLong("ID"));
		member.setRegisterDate(
				new java.sql.Timestamp(
						rs.getDate("REGDATE").getTime())
				.toLocalDateTime());
		return member;
	}
}
