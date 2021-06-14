package bit.com.a.dto;

public class classScheduleDto {
	private String rdate;
	private int price;
	private String duration;
	private String limitNum;
	
	public classScheduleDto() {
	}

	public classScheduleDto(String rdate, int price, String duration, String limitNum) {
		super();
		this.rdate = rdate;
		this.price = price;
		this.duration = duration;
		this.limitNum = limitNum;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(String limitNum) {
		this.limitNum = limitNum;
	}

	@Override
	public String toString() {
		return "classScheduleDto [rdate=" + rdate + ", price=" + price + ", duration=" + duration + ", limitNum="
				+ limitNum + "]";
	}
}
