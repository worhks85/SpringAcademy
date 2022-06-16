package exam;

public class Main {
	public static void main(String[] args) {
	
	Calculator repe = new RepeCalculator();
	Calculator recu = new RecuCalculator();
	

	long ret1 = repe.factorial(4);
	long ret2 = recu.factorial(4);
	
	System.out.println(ret1);
	System.out.println(ret2);
	
	}
}
