package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.noClassDateDto;

@Mapper
@Repository
public interface noClassDateDao {
	public int addNoClassDate(noClassDateDto dto);
}
