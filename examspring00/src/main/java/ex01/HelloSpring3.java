package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring3 {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("appctx3.xml");
		System.out.println("스프링 컨테이너 생성 완료!");
		
		Greeter gr1 = ctx.getBean("greeter1",Greeter.class);
		Greeter gr2 = ctx.getBean("greeter2",Greeter.class);
		
		System.out.println(gr1 == gr2);
	}
}