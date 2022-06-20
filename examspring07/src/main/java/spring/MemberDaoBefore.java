package spring;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//이제 데이터베이스 연동으로 변경!
public class MemberDaoBefore {
	private static long nextId = 0;
	private Map<String, Member> db = new HashMap<>();
	
	public MemberDaoBefore() {
		System.out.println("MemberDao()");
	}
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
	
	//전체 목록
	public List<Member> selectAll(){
		return new ArrayList<Member>(db.values());
	}
}











