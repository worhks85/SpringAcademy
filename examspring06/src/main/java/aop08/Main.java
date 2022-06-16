package aop08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop08.xml");
		
		Person alice = ctx.getBean("programmer", Person.class);
		Person bob = ctx.getBean("progamer", Person.class);
		
		int ret1 = alice.usingComputer("1234");
		System.out.println(alice.getClass().getSimpleName() + "결과:"+ret1);
		System.out.println("===================");
		int ret2 = bob.usingComputer("4321");
		System.out.println(bob.getClass().getSimpleName() + "결과:"+ret2);
	}
}
