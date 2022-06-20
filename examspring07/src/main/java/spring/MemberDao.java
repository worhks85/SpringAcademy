package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		System.out.println("MemberDao()");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//멤버 검색
	public Member selectByEmail(String email) {
		String sql = "select * from member where email =?";
		//		List<Member> res = jdbcTemplate.query(sql,new MemberRowMapper(),email);
		//		return res.isEmpty() ? null : res.get(0);
		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(),email);
		
	}

	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM MEMBER" , Integer.class);

	}
	//멤버 등록
	public void insert(Member member) {
		String sql = "INSERT INTO MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) "
				+ "VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		jdbcTemplate.update(sql,member.getEmail(),member.getPassword(),member.getName());
	}

	//멤버 수정
	public void update (Member member) {
		String sql = "UPDATE MEMBER SET NAME =? , PASSWORD = ? WHERE EMAIL = ?";
		jdbcTemplate.update(new PreparedStatementCreator( ) {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getEmail());
				return pstmt;
			}
			
		});
	}
//	public void update(Member member) {
//		String sql = "UPDATE MEMBER SET NAME =? , PASSWORD = ? WHERE EMAIL = ?";
//		jdbcTemplate.update(sql,member.getName(),member.getPassword(),member.getEmail());
//		
//	}

	//전체 목록
	public List<Member> selectAll(){
		String sql = "select * from member";
		List<Member> res = jdbcTemplate.query(sql,new MemberRowMapper());
		return res;
	}
}
