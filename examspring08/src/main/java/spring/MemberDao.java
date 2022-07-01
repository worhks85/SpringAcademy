package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		System.out.println("MemberDao()");
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	//멤버 검색
	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(), email);
		return result.isEmpty() ? null : result.get(0);
		//return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), email);
	}
	
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM MEMBER", Integer.class);
	}
	
	//멤버 수정
//	public void update(Member member) {
//		String sql = "UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?";
//		jdbcTemplate.update(sql, 
//				member.getName(), member.getPassword(), member.getEmail());
//	}

//	public void update(Member member) {
//		String sql = "UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?";
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, member.getName());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getEmail());
//				return pstmt;
//			}
//			
//		});
//	}
	
	class MyPreparedStatementCreator implements PreparedStatementCreator {

		private String sql;
		private Member member;
		
		public MyPreparedStatementCreator(String sql, Member member) {
			this.sql = sql;
			this.member = member;
		}
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			return pstmt;
		}
	}
	public void update(Member member) {
		String sql = "UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?";
		jdbcTemplate.update(new MyPreparedStatementCreator(sql, member));
	}
	
	//전체 목록
	public List<Member> selectAll(){
		String sql = "SELECT * FROM MEMBER";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper());
		return result;
	}
	
	//멤버 등록
//	public void insert(Member member) {
//		StringBuffer sql = new StringBuffer();
//		sql.append("INSERT INTO MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) ");
//		sql.append("VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)");
//		System.out.println(sql.toString());
//		jdbcTemplate.update(
//				sql.toString(), 
//				member.getEmail(),
//				member.getPassword(),
//				member.getName());
//	}
	//키홀더 활용
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) ");
				sql.append("VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)");
				System.out.println(sql.toString());
				
				PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				return pstmt;
			}
			
		}, keyHolder);
		System.out.println(keyHolder.getKeyList());
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
		
	}
}











