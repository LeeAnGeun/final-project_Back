package bit.com.a;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class FileUploadUtiles {

	// 파일 처리를 위한 유틸파일
	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String filename) {
		String minType = servletContext.getMimeType(filename);

		try {
			MediaType mediaType = MediaType.parseMediaType(minType);
			return mediaType;
		} catch (Exception e){
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}

		// newfilename 만들기
	public static String getNewFilename(String f, int num) {

		String filename = "";
		String fpost = "";

		//확장자명이 있다면
		if(f.indexOf('.') >= 0) {
			fpost = f.substring( f.indexOf('.') );	    // 확장자 
			filename = new Date().getTime() + num + fpost;    // newfilename 
		}
		//확장자명이 없다면
		else {
			filename = new Date().getTime() + ".back";  // newfilename 
		}
		return filename;
	}

}