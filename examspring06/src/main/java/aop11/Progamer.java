package aop11;

public class Progamer implements Person{
	public int usingComputer(String pwd) {
		
		try {
			System.out.println("[게임을 한다.]");  //핵심기능
		}catch(Exception e) {
			if(e.getMessage().equals("오류")) {
			}
		}
		return 200;
	}
}
