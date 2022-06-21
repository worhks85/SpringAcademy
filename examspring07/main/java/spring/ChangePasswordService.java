package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		System.out.println("ChangePasswordService(MemberDao)");
		this.memberDao = memberDao;
	}
	
	public ChangePasswordService() {
		System.out.println("ChangePasswordService()");
	}
	
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
