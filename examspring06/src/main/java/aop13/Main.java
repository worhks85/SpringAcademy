package aop13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop13.xml");

		Person alice = ctx.getBean("programmer", Person.class);
		Person bob = ctx.getBean("progamer", Person.class);

		try {
			int ret1 = alice.usingComputer("1234");
			System.out.println(alice.getClass().getSimpleName() + "결과:"+ret1);

		} catch (Exception e) {
			System.out.println("alice동작중 예외 발생");
		}
		
		System.out.println("=================================");
		
		try {		
			int ret2 = bob.usingComputer("4321");
			System.out.println(bob.getClass().getSimpleName() + "결과:"+ret2);
		} catch (Exception e) {
			System.out.println("bob동작중 예외 발생");
		}
		
	}
}
