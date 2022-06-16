package aop01;

//프록시 객체 정의
public class Proxy implements Person{
	private Person delegate;
	
	public Proxy(Person delegate) {
		this.delegate = delegate;
	}

	@Override
	public int usingComputer(String pwd) {
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
		return delegate.usingComputer(pwd); //핵심 기능 실행
	}

}
