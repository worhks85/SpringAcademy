package aop01;

public class Main {
	public static void main(String[] args) {
		//Programmer p1 = new Programmer();
		//Progamer p2 = new Progamer();
		
		Person p1 = new Proxy(new Programmer());
		Person p2 = new Proxy(new Progamer());
		
		int ret1 = p1.usingComputer("1234");
		System.out.println(p1.getClass().getSimpleName() + "결과:"+ret1);
		System.out.println("===================");
		int ret2 = p2.usingComputer("4321");
		System.out.println(p2.getClass().getSimpleName() + "결과:"+ret2);
	}
}
