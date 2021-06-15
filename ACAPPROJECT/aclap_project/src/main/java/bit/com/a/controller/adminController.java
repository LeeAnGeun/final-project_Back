package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.aclapParam;
import bit.com.a.dto.noticeBbsDto;
import bit.com.a.dto.noticeBbsParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;
import bit.com.a.service.aclapMemberService;
import bit.com.a.service.noticeBbsService;
import bit.com.a.service.onedayClassService;

@RestController
public class adminController {
	//----------------------관리자의 문의사항 확인 부분----------------------//
		@Autowired
		noticeBbsService noticeBbsService;
		@Autowired
		aclapMemberService aclapMemberService;
		@Autowired
		onedayClassService onedayClassService;
		
		//------------------문의사항 리스트 가져오기-------------------------//
		@RequestMapping(value="/noticeListData", method = {RequestMethod.GET, RequestMethod.POST})
		public List<noticeBbsDto> bbslistData(noticeBbsParam param){
			System.out.println("bbslistData " + new Date());
			// paging 처리
					int sn = param.getPage();
					int start = sn * 10 + 1;	// 1 	11
					int end = (sn + 1) * 10; 	// 10   20
					
					param.setStart(start);
					param.setEnd(end);
			List<noticeBbsDto> list = noticeBbsService.noticeListData(param);
			//System.out.println(list.toString());
			
			System.out.println("확인"+list.toString());
			return list;
			
		}
		//-------------------총 문의갯수 조사------------------------------//
		@RequestMapping(value="/noticeListCount", method = {RequestMethod.GET, RequestMethod.POST})
		public int noticeListCount(noticeBbsParam param) {
			System.out.println("noticeListCount() " + new Date());
			int count = noticeBbsService.noticeListCount(param);
			
			System.out.println("확인: " + count);
			return count;
		}
		//--------------------문의사항 디테일 가져오기 ------------------------//
		@RequestMapping(value="/noticeDetail", method = {RequestMethod.GET, RequestMethod.POST})
		public noticeBbsDto noticeDetail(int seq) {
			System.out.println("noticeDetail " + new Date());
			noticeBbsDto bbs = noticeBbsService.noticeDetail(seq);
			
			System.out.println("확인: " + bbs.toString());
			return bbs;
		}
		
		//--------------------------------답변이후에--------------------------//
		@RequestMapping(value="/noticeAnswerAf", method = {RequestMethod.GET, RequestMethod.POST})
		public void noticeAnswerAf(int seq) {
			System.out.println("noticeAnswerAf " + new Date());
			noticeBbsService.noticeAnswerAf(seq);
			
			System.out.println("답변완료실행해줌");
		}
		
		//--------------------------------회원정보불러오기--------------------------//
		
		@RequestMapping(value = "/memlist", method = {RequestMethod.GET, RequestMethod.POST})
		public List<aclapMemberDto> memlist(aclapParam par){
			System.out.println("aclapMemberController memlist" + new Date());
			System.out.println(par.getName() + par.getPage());
			System.out.println(par.toString());

			int sn = par.getPage(); // 0 1 2
			int start = sn*10+1;       // 1 11 21
			int end = (sn + 1)*10;	   // 10 20 30 
			
			par.setStart(start);
			par.setEnd(end);
			
		//	System.out.println("par = " + par.toString());
			List<aclapMemberDto> list = aclapMemberService.memlist(par);
		//	System.out.println(list.toString());	
			return list;
			
			
		}
		
		//--------------------------------클래스목록--------------------------//


		@RequestMapping(value = "/classlist", method = {RequestMethod.GET, RequestMethod.POST})
		public List<onedayClassDto> classlist(onedayParam par) {
			System.out.println("onedayClassController classlist()" + new Date());
		//	System.out.println(par.getName() + par.getPage());
		//	System.out.println(par.toString());
			
			int sn = par.getPage(); // 0 1 2
			int start = sn*10+1;       // 1 11 21
			int end = (sn + 1)*10;	   // 10 20 30 
			
			par.setStart(start);
			par.setEnd(end);
			
			List<onedayClassDto> list = onedayClassService.getClassList(par);	
			System.out.println(list.toString());		
			return list;
		}
		//--------------------------------클래스 갯수 카운트 리턴--------------------------//
		
		@RequestMapping(value = "/classCount", method = {RequestMethod.GET, RequestMethod.POST})
		public int classCount(onedayParam par) {
			System.out.println("onedayClassController classCount()" + new Date());
			 int count = onedayClassService.classCount(par);
			return count;
		}
		
		@RequestMapping(value = "/userCount", method = {RequestMethod.GET, RequestMethod.POST})
		public int userCount(onedayParam par) {
			System.out.println("userCount userCount()" + new Date());
			int count = aclapMemberService.userCount(par);
			return count;
		}
		
		
		
}
