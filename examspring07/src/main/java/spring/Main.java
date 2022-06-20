package spring;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("appctx.xml");
		MemberDao memberDao = ctx.getBean("memberDao",MemberDao.class);
		Member member = new Member("worhks5017@naver.com", "5017", "jk");
		memberDao.insert(member);
		Member m1 = memberDao.selectByEmail("worhks5017@naver.com");
		System.out.println(m1);
		
//		List<Member> ls = memberDao.selectAll();
//		for(Member member : ls) {
//			System.out.println(member);
//		}
//		Member m1  = memberDao.selectByEmail("tester@test.com");
//		System.out.println(m1);
//		
//		System.out.println(memberDao.count());
//		Member m = new Member("tester@test.com", "1234", "test");
//		memberDao.update(m);
//		System.out.println(memberDao.selectByEmail("tester@test.com"));
	}
}
