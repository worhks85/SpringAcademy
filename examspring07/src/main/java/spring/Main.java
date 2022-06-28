package spring;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		List<Member> ls = memberDao.selectAll();
		for(Member member : ls) {
			System.out.println(member);
		}

		System.out.println();
		Member m1 = memberDao.selectByEmail("tester@test.com");
		System.out.println(m1);
		System.out.println();
		
		System.out.println(memberDao.count());
		System.out.println();
		
		Member m = new Member("tester@test.com", "KKK", "4444");
		memberDao.update(m);
		System.out.println(memberDao.selectByEmail("tester@test.com"));
		
		Member newMember = new Member(
				"tester"+System.currentTimeMillis()+"@test.com", "1234", "HHH");
		memberDao.insert(newMember);
		
		System.out.println("가입된 멤버 정보:" + newMember);
		//System.out.println(memberDao.selectByEmail(newMember.getEmail()));
		//키 홀더를 이용하면 자동 생성된 키 값을 insert만으로 얻어 올 수 있음
		
		
	}
}







