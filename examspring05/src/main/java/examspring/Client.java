package examspring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 * InitializingBean : 빈생성 후 의존 주입까지 완료 후 스프링이 호출할 메서드 를 정의(초기화 메서드)
 * DisposableBean : 컨테이너 종료시 빈 소멸 전에  스프링이 호출할 메서드를 정의(소멸 메서드)
 *  
 * 
 */
public class Client implements InitializingBean, DisposableBean{
	private String host;

	public Client() {
		System.out.println("2. Client()");
	}

	public void setHost(String host) {
		this.host = host;
		System.out.println("3. Client.setHost()");
	}

	public void send() {
		System.out.println("6. Client.send() to " + host);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("8. Client.destroy() 메서드 호출");
		System.out.println("의존 주입에 지정된" + host +"에 연결을 해제함");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("4. Client.afterPropertiesSet() 메서드 호출");
		System.out.println("   의존 주입에 지정된" + host +"에 연결함");

	}
}
