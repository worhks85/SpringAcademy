package examspring;


//타 라이브러리에 정의된 클래스라고 가정(코드를 수정하지 못함)

public class Client2 {
	private String host;

	public Client2() {
		System.out.println("2. Client2()");
	}

	public void setHost(String host) {
		this.host = host;
		System.out.println("3. Client2.setHost()");
	}

	public void send() {
		System.out.println("6. Client2.send() to " + host);
	}

	
	public void close() throws Exception {
		System.out.println("8. Client2.destroy() 메서드 호출");
		System.out.println("의존 주입에 지정된" + host +"에 연결을 해제함");

	}

	public void connect() throws Exception {
		System.out.println("4. Client2.afterPropertiesSet() 메서드 호출");
		System.out.println("   의존 주입에 지정된" + host +"에 연결함");

	}
}
