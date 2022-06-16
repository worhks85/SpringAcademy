package exam;

public class RepeCalculator  implements Calculator{

	@Override
	public long factorial(long num) {
		long res = 1;
		for (int i =1 ; i<=num ; i++) {
			res *= i ;
		}
		return res;
	}



}
