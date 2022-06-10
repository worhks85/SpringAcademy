package spring;

// 멤버를 등록하는 기능만(SRP : 단일 책임 원칙)	
public class MemberRegisterService {
	private MemberDAO memberDao;
	public MemberRegisterService(MemberDAO dao) {
		this.memberDao = dao;
	}
	
	public void regist(RegisterRequest regReq) {
		Member member = memberDao.selectByEmail(regReq.getEmail());
		if(member != null ) {
			throw new AleadyExistingMemberException("중복 : " + regReq.getEmail());
		}
		
		Member newMember = new Member(regReq.getEmail(), 
				regReq.getPassword(), regReq.getName());
		
		memberDao.insert(newMember); //등록
	}
	
}
