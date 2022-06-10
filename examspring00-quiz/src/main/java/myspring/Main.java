package myspring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam2.CountCalculator;

public class Main {

	public static void main(String[] args) {
		ApplicationContext apc =
				new ClassPathXmlApplicationContext("appctx.xml");
		CountCalculator cal = (CountCalculator) apc.getBean("cntcal");

		
		
	
	}

}
