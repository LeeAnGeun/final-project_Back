package bit.com.a.dto;

public class oneDayClassParam {
	
	private String choice;
	private String search;
	private int page;
	
	private String primaryCategory;
	
	private int start;
	private int end;
	
	public oneDayClassParam() {
		// TODO Auto-generated constructor stub
	}

	public oneDayClassParam(String choice, String search, int page, String primaryCategory, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.page = page;
		this.primaryCategory = primaryCategory;
		this.start = start;
		this.end = end;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
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
		return "oneDayClassParam [choice=" + choice + ", search=" + search + ", page=" + page + ", primaryCategory="
				+ primaryCategory + ", start=" + start + ", end=" + end + "]";
	}


	
}
