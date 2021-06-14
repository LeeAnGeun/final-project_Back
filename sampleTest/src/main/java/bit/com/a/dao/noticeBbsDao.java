package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.noticeBbsDto;
import bit.com.a.dto.noticeBbsParam;

@Mapper
@Repository
public interface noticeBbsDao {

	public List<noticeBbsDto> noticeListData(noticeBbsParam param);

	public int noticeListCount(noticeBbsParam param);

	public noticeBbsDto noticeDetail(int seq);

	public void noticeAnswerAf(int seq);

	public int writeNotisBbs(noticeBbsDto dto);

	public int noAnserNoticeCount();
	
	public int delnoticeBbs(aclapMemberDto dto);
}
