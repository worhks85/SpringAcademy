package examspring06;

public class Main {
	public static void main(String[] args) {
		Calculator add = new Proxy(new AddCalculator());
		Calculator min = new Proxy(new MinCalculator());
		
		int n1 = 10;
		int n2 = 6;
		
		System.out.println(add.calc(n1, n2));
		System.out.println(min.calc(23, 5));
	}
}
