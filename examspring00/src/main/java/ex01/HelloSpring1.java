package ex01;

public class HelloSpring1 {
	public static void main(String[] args) {
		
		Greeter gr = new Greeter();
		
		gr.setFormat("%s 님 하이");
		System.out.println(gr.greet("홍길동"));
	}
}
