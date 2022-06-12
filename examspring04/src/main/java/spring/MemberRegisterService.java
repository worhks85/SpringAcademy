package spring;

import org.springframework.beans.factory.annotation.Autowired;

//멤버를 등록하는 기능만(SRP:단일 책임 원칙)
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		System.out.println("MemberRegisterService(MemberDao)");
		this.memberDao = memberDao; //의존 주입(DI)
	}
	
	public MemberRegisterService() {
		System.out.println("MemberRegisterService()");
	}
	
	public void regist(RegisterRequest regReq) {
		System.out.println("memberDao:" + memberDao);
		Member member = memberDao.selectByEmail(regReq.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException(
					"중복:" + regReq.getEmail());
		}
		
		Member newMember = new Member(
				regReq.getEmail(),
				regReq.getPassword(),
				regReq.getName());
		
		memberDao.insert(newMember); //등록
	}
	
}




