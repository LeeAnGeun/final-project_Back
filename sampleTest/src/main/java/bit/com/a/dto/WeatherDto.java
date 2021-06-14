package bit.com.a.dto;

import java.io.Serializable;

public class WeatherDto implements Serializable{

		private String cities;
		private String temperature;
		private String winfo;
		
		public WeatherDto() {}

		public WeatherDto(String cities, String temperature, String winfo) {
			super();
			this.cities = cities;
			this.temperature = temperature;
			this.winfo = winfo;
		}

		public String getCities() {
			return cities;
		}

		public void setCities(String cities) {
			this.cities = cities;
		}

		public String getTemperature() {
			return temperature;
		}

		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}

		public String getwinfo() {
			return winfo;
		}

		public void setwinfo(String winfo) {
			this.winfo = winfo;
		}

		@Override
		public String toString() {
			return "WeatherDto [cities=" + cities + ", temperature=" + temperature + ", winfo=" + winfo + "]";
		}
		
		
}
