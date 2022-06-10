package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring2 {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("appctx.xml");
		System.out.println("스프링 컨테이너 생성 완료!");
		
		Greeter gr = ctx.getBean("greeter",Greeter.class);
		
		System.out.println(gr.greet("홍길동"));
	}
}
