package bit.com.a.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bit.com.a.dto.BlogSearchDto;

public class BlogSearchCrawling {
	public static List<BlogSearchDto> naverSearch(String keyword) throws IOException {	
		
		// jsoup 생성
		Document doc = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query="+keyword).get();

		// html 정보 얻어오기	
		Elements blog = doc.select("div.main_pack div.total_wrap.api_ani_send a.api_txt_lines.total_tit");
		
		// 정보를 저장할 List 생성
		List<BlogSearchDto> list = new ArrayList<>();

		// 원하는 정보 추출 
		for(int i = 0;i < blog.size(); i++) {
			Element content = blog.get(i);
			String title = content.text();      // text 뽑아오기
			String url = content.attr("href");  // attr 뽑아오기
			
			System.out.println(i+1+"제목 : "+title+" url : "+url);
			System.out.println("");

			// 리스트에 담기
			BlogSearchDto dto = new BlogSearchDto ();
			dto.setTitle(title);
			dto.setUrl(url);
			list.add(dto);
		}
		return list;
	}
}
