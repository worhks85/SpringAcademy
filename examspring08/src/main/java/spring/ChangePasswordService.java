package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangePasswordService {
	@Autowired
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
		System.out.println("========================");
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
		System.out.println("========================");
	}
}
