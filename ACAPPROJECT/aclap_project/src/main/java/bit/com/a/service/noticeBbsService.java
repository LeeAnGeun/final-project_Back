package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.noticeBbsDao;
import bit.com.a.dto.noticeBbsDto;
import bit.com.a.dto.noticeBbsParam;

@Service
@Transactional
public class noticeBbsService {

	
	@Autowired
	noticeBbsDao noticeBbsDao;
	
	public List<noticeBbsDto> noticeListData(noticeBbsParam param) {
		return noticeBbsDao.noticeListData(param);
	}

	public int noticeListCount(noticeBbsParam param) {
		return noticeBbsDao.noticeListCount(param);
	}

	public noticeBbsDto noticeDetail(int seq) {
		return noticeBbsDao.noticeDetail(seq);
	}

	public void noticeAnswerAf(int seq) {
		noticeBbsDao.noticeAnswerAf(seq);
		
	}

}