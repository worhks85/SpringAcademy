package exam2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appctx2.xml");
		CountCalculator calc = ctx.getBean("calc", CountCalculator.class);
		
		System.out.println(calc.add(1, 2));
		System.out.println(calc.add(32, 24));

		System.out.println(calc.min(3, 2));
		System.out.println(calc.min(5, 1));
		System.out.println(calc.min(6, 4));
		System.out.println("=======================");
		System.out.println(calc.getAddCounter());
		System.out.println(calc.getMinCounter());
		
	}
}

