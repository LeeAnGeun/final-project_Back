package bit.com.a.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bit.com.a.dto.BlogSearchDto;

public class BlogSearchCrawlingTest {
	public static void main(String[] args) {
		List<BlogSearchDto>list = new ArrayList<>();
		try {
			list = BlogSearchCrawling.naverSearch("외국어");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (BlogSearchDto dto : list) {
			System.out.println(dto.getUrl());
		}
	}

}
