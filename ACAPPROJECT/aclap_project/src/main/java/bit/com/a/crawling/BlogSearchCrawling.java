package bit.com.a.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BlogSearchDto;
import bit.com.a.service.aclapMemberService;

@RestController
public class BlogSearchCrawling {
	@Autowired
	aclapMemberService service;
	
	@RequestMapping(value="/getYourInterest", method = {RequestMethod.GET, RequestMethod.POST})
	public String getYourInterest(int seq) {
	//	System.out.println("조사할 맴버 넘버: " +seq);
		
		String yourInterest = service.getYourInterest(seq);
		
		return yourInterest;
		
	}
	
	@RequestMapping(value="/blog", method = {RequestMethod.GET, RequestMethod.POST})
	public static List<BlogSearchDto> naverSearch(String keyword) throws IOException {	
	//	System.out.println("파라미터 keyword == "+ keyword);
		// jsoup 생성
		//String searchUrl = "https://section.blog.naver.com/Search/Post.naver?pageNo=1&rangeType=ALL&orderBy=sim&keyword=";
		String naverUrl = "https://search.naver.com/search.naver?sm=tab_hty.top&where=blog&query=";
		naverUrl += keyword+"+수업";
		naverUrl += "&oquery=&tqi=h7l1Mdp0YidssCX9EqVssssst6R-274174";
	//	System.out.println(naverUrl.trim());
		// 정보를 저장할 List 생성
		List<BlogSearchDto> list = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(naverUrl)
							.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36")
							.header("scheme", "https")
				            .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				            .header("accept-encoding", "gzip, deflate, br")
				            .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
				            .header("cache-control", "no-cache")
				            .header("pragma", "no-cache")
				            .header("upgrade-insecure-requests", "1")
							.get();
			// html 정보 얻어오기	
			Elements blog = doc.select("li.bx div.total_wrap.api_ani_send div.total_area a.api_txt_lines.total_tit");
			
			//Elements titles = doc.select("li.bx div.total_wrap div.total_area a.thumb_single");
			
			//Elements urls = doc.select("li.bx div.total_wrap div.total_area a.thumb_single");
			
			
			
			//System.out.println(blog);
			
			//System.out.println(list);
			// 원하는 정보 추출 
			for(int i = 0;i < 7; i++) {
				Element content = blog.get(i);
				//Element title = titles.get(i);
				//Element url = urls.get(i);
				
				String rtitle = content.text();      // text 뽑아오기
				String rurl = content.attr("href");  // attr 뽑아오기
				
			//	System.out.println(i+1+"제목 : "+rtitle+" url : "+rurl);
			//	System.out.println("");

				// 리스트에 담기
				BlogSearchDto dto = new BlogSearchDto ();
				dto.setTitle(rtitle);
				dto.setUrl(rurl);
				list.add(dto);
			}
			//System.out.println(list.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		return list;
		
	
	}
}
