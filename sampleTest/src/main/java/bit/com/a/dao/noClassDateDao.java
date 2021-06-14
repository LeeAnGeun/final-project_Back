package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.noClassDateDto;
import bit.com.a.dto.onedayClassDto;

@Mapper
@Repository
public interface noClassDateDao {
	public int addNoClassDate(noClassDateDto dto);
	public List<String> getNoClassDate(onedayClassDto dto);
	public int deleteNoClassDate(onedayClassDto dto);
}