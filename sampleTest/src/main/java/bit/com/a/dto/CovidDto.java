package bit.com.a.dto;

import java.io.Serializable;

public class CovidDto implements Serializable{

		private String cities;
		private String coronic;
		
		public CovidDto() {
			// TODO Auto-generated constructor stub
		}

		public CovidDto(String cities, String coronic) {
			super();
			this.cities = cities;
			this.coronic = coronic;
		}

		public String getCities() {
			return cities;
		}

		public void setCities(String cities) {
			this.cities = cities;
		}

		public String getCoronic() {
			return coronic;
		}

		public void setCoronic(String coronic) {
			this.coronic = coronic;
		}

		@Override
		public String toString() {
			return "CovidDto [cities=" + cities + ", coronic=" + coronic + "]";
		}
		
		
		
}
