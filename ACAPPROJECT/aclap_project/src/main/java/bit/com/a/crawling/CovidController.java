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

import bit.com.a.dto.CovidDto;



@RestController
public class CovidController {
	
		@RequestMapping(value="/covid", method = {RequestMethod.GET, RequestMethod.POST})
		public static List<CovidDto> getCovidData() throws IOException{
		//Jsoup : 각종 사이트에서 데이트를 취합할 수 있는 라이브러리
		//	System.out.println("코로나 크롤링");
				Document doc = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98").get();
				

				 
				Elements cities = doc.select("tbody tr td.align_center span.text a.link_more");
				
				Elements coronic = doc.select("tbody tr td.align_right span.confirmed_case");
				
			
				
				List<CovidDto> list = new ArrayList<CovidDto>(); 
				
				for(int i=0; i<17; i++) {
					
					Element city = cities.get(i);
					Element corona = coronic.get(i);
				
					
					String c = city.text();
					String covid = corona.text();
				
					CovidDto dto = new CovidDto();
					dto.setCities(c);
					dto.setCoronic(covid);
				
					
					list.add(dto);
					
				//	System.out.println(dto.toString());
					
				}
				return list;
		
	}
}
