package myspring;

import java.util.Scanner;

public class Calculator {
	Scanner sc = new Scanner(System.in);
	
	public void plus(int a , int b) {
		System.out.println(a +"+"+ b + "=" +(a+b));
	}
	
	public void min (int a , int b) {

		System.out.println(a +"-"+ b + "=" + (a-b));
	}
	
	public void gob (int a , int b) {

		System.out.println(a +"*"+ b + "=" +(a*b));
	}
	public void nanu (int a , int b) {
		System.out.println(a +"/"+ b + "=" +(a/b));
	}
}
