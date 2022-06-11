package spring;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member> db = new HashMap<>();
	
	//멤버 검색
	public Member selectByEmail(String email) {
		return db.get(email);
	}
	
	//멤버 등록
	public void insert(Member member) {
		member.setId(++nextId);
		member.setRegisterDate(LocalDateTime.now());
		db.put(member.getEmail(), member);
	}
	
	//멤버 수정
	public void update(Member member) {
		db.put(member.getEmail(), member);
	}
}











