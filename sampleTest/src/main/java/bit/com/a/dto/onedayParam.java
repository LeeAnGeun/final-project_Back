package bit.com.a.dto;

public class onedayParam {
	
	private String name;
	private int page;
	
	private int start;
	private int end;
	
	public onedayParam() {
		// TODO Auto-generated constructor stub
	}

	public onedayParam(String name, int page, int start, int end) {
		super();
		this.name = name;
		this.page = page;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "onedayParam [name=" + name + ", page=" + page + ", start=" + start + ", end=" + end + "]";
	}
	
	

}
