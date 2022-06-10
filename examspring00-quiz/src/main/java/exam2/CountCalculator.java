package exam2;

public class CountCalculator extends Calculator{

	private Counter addCounter;
	private Counter minCounter;
	private Counter mulCounter;
	private Counter divCounter;
	
	public void setAddCounter(Counter counter) {
		this.addCounter = counter;
	}
	public void setMinCounter(Counter counter) {
		this.minCounter = counter;
	}
	public void setMulCounter(Counter counter) {
		this.mulCounter = counter;
	}
	public void setDivCounter(Counter counter) {
		this.divCounter = counter;
	}
	
	public int getAddCounter() {
		return addCounter.getCount();
	}
	public int getMinCounter() {
		return minCounter.getCount();
	}
	public int getMulCounter() {
		return mulCounter.getCount();
	}
	public int getDivCounter() {
		return divCounter.getCount();
	}
	
	@Override
	public int add(int n1, int n2) {
		addCounter.increment();
		return super.add(n1, n2);
	}
	
	@Override
	public int min(int n1, int n2) {
		minCounter.increment();
		return super.min(n1, n2);
	}
	
	@Override
	public int mul(int n1, int n2) {
		mulCounter.increment();
		return super.mul(n1, n2);
	}
	
	@Override
	public int div(int n1, int n2) {
		divCounter.increment();
		return super.div(n1, n2);
	}
	
	
	
}