package bit.com.a.crawling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.WeatherDto;



@RestController
public class WeatherController {
	
		@RequestMapping(value="/weather", method = {RequestMethod.GET, RequestMethod.POST})
		public static List<WeatherDto> getWeatherData() throws IOException{
		//Jsoup : 각종 사이트에서 데이트를 취합할 수 있는 라이브러리
		//	System.out.println("도착했다");
				Document doc = Jsoup.connect("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EA%B5%AD%EB%82%B4+%EB%82%A0%EC%94%A8&oquery=%EB%82%A0%EC%94%A8&tqi=h5ntXsp0YihssEPPQeNssssss1C-503915").get();
				
				//도시이름
				
			    //<div class="map _map_normal"> <a class="w_tit ct001013_a"> <span>
			
				//날씨 온도 정보
				//<div class="map _map_normal"> <a class="w_box ct001013"> <span class="dsc"> </span>
				//
				//날씨 기본정보
				//<div class="map _map_normal"> <a class="w_box ct001013"> <span class="state state21"> </span>
				
				Elements cities = doc.select("div.map._map_normal a.w_tit span");
				
				Elements temperature = doc.select("div.map._map_normal a.w_box span.dsc");
				
				Elements winfos = doc.select("div.map._map_normal a.w_box span.state");
				
				List<WeatherDto> list = new ArrayList<WeatherDto>(); 
				
				for(int i=0; i<12; i++) {
					
					Element city = cities.get(i);
					Element temp = temperature.get(i);
					Element winfo = winfos.get(i);
					
					String c = city.text();
					String t = temp.text();
					String w = winfo.text();
					
				//	System.out.println(c);
				//	System.out.println(t);
				//	System.out.println(w);
					
					WeatherDto dto = new WeatherDto();
					dto.setCities(c);
					dto.setTemperature(t);
					dto.setwinfo(w);
					
					list.add(dto);
					
				}
				return list;
		
	}
}
