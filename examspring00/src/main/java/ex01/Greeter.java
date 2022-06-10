package ex01;

public class Greeter {
	private String format;
	public Greeter() {
		System.out.println("그리터 생성 시작");
	}
	
	public void setFormat(String guest) {
		this.format = guest; 
	}
	
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
}
