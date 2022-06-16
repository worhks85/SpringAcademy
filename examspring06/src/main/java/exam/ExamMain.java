package exam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamMain {
	public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx =
			new ClassPathXmlApplicationContext("exam.xml");
		
	Calculator repe = ctx.getBean("repeCalc",Calculator.class);
	Calculator recu = ctx.getBean("recuCalc", Calculator.class);
	

	long ret1 = repe.factorial(4);
	long ret2 = recu.factorial(4);
	System.out.println();
	System.out.println(ret1);
	System.out.println(ret2);
	
	}
}
