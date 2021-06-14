package bit.com.a.dto;

public class classSchedulCount {
	private int count;
	private String rdate;
	
	public classSchedulCount() {
	}

	public classSchedulCount(int count, String rdate) {
		super();
		this.count = count;
		this.rdate = rdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "classSchedulCount [count=" + count + ", rdate=" + rdate + "]";
	}
}
