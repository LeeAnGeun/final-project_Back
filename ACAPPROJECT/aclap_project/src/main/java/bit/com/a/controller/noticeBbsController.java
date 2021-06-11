package bit.com.a.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.noticeBbsDto;
import bit.com.a.service.noticeBbsService;

@RestController
public class noticeBbsController {
	@Autowired
	noticeBbsService noticeBbsService;
	
	// 문의 글 쓰기 
	@RequestMapping(value = "/writeNotisBbs", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean writeNotisBbs(noticeBbsDto dto) {
		System.out.println("////// noticeBbsController writeNotisBbs() ///////");
		System.out.println(dto.toString());
		boolean result = false;
		result = noticeBbsService.writeNotisBbs(dto);
		return result;
	};
	
	@RequestMapping(value = "/noAnserNoticeCount", method = RequestMethod.POST)
	public int noAnserNoticeCount() {
		System.err.println("noAnserNoticeCount");
		int count = noticeBbsService.noAnserNoticeCount();
		System.out.println("noAnserNoticeCount count = " + count);
		
		return count;
	}

}