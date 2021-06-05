package bit.com.a;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class NoClassUtil {
	public static List<String> getNoClassList(String SDate, String eDate, String week) {
				
		// noClass를 담을 주머니
		List<String>list = new ArrayList<>();

		for(int i=0; i<week.length(); i++) {
			char ch = week.charAt(i);
			
			//String -> LocalDate
			LocalDate startDate = LocalDate.parse(SDate);
			LocalDate endDate = LocalDate.parse(eDate);
			
			// 연, 월, 일 분리
			int year = startDate.getYear(); 
			int month = startDate.getMonthValue();
			int date= startDate.getDayOfMonth(); 
			
			// endDate - StartDate 날짜값 
			long d = ChronoUnit.DAYS.between(startDate, endDate);
			
			while(d>0) {
				if(ch=='7') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.SUNDAY))); 
				else if (ch=='1') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.MONDAY))); 
				else if (ch=='2') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.TUESDAY))); 
				else if (ch=='3') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY))); 
				else if (ch=='4') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.THURSDAY))); 
				else if (ch=='5') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.FRIDAY))); 
				else if (ch=='6') 
					startDate = (LocalDate.of(year, month, date).with(TemporalAdjusters.next(DayOfWeek.SATURDAY))); 
				
				year = startDate.getYear(); 
				month = startDate.getMonthValue();
				date= startDate.getDayOfMonth(); 
	
				list.add(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				d = ChronoUnit.DAYS.between(startDate, endDate); 
			}
		}
		return list;
	}
	
	// 날짜 -> 요일넘버 
	public static String getNoclassDayOfWeek(List<String> day) {
		// 중복제거를 위해 treemap 사용
		TreeSet<Integer> result = new TreeSet<>();
		// 최종 String 출력을 위한 StringBuffer
		StringBuffer sb = new StringBuffer(50);  
		for(int i=0; i<day.size(); i++) {
			LocalDate item = LocalDate.parse(day.get(i));
			result.add(item.getDayOfWeek().getValue());
		}
		
		for (Integer integer : result) 
			sb.append(integer);
		return sb.toString();
	}
}
