package examspring06;

public class Proxy implements Calculator{
	private Calculator calculator;
	
	public Proxy(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public int calc(int n1, int n2) {
		System.out.println(calculator.getClass().getSimpleName() + "=> n1:" + n1 + ", n2:" + n2);
		return calculator.calc(n1, n2);
	}

	
}
