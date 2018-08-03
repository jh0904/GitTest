package java8.timetest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * java8.timetest
 *
 * @author jh
 * @date 2018/8/3 18:13
 * description:
 */
public class TestLocalTime {

	//带时区的时间API

	@Test
	public void test8(){
		LocalDateTime ldt = LocalDateTime.now (ZoneId.of ("Asia/Tokyo"));
		System.out.println (ldt);

		LocalDateTime ldt2 = LocalDateTime.now (ZoneId.of ("Asia/Tokyo"));
		ZonedDateTime zdt = ldt2.atZone (ZoneId.of ("Asia/Tokyo"));
		System.out.println (zdt);
	}
	@Test
	public void test7(){
		Set<String> set = ZoneId.getAvailableZoneIds ();
		for (String s : set) {
			System.out.println (s);
		}
	}
	/*
	* DateTimeFormatter:格式化时间
	* */

	@Test
	public void test6(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now ();

		String format = ldt.format (dtf);
		System.out.println (format);

		System.out.println ("--------------");

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern ("yyyy年MM月dd日 HH:mm:ss");

		String format1 = dtf2.format (ldt);
		System.out.println (format1);

		LocalDateTime parse = ldt.parse (format1,dtf2);
		System.out.println (parse);
	}
	/*
	 * 时间校正器
	 * */
	@Test
	public void test5() {
		LocalDateTime ldt = LocalDateTime.now ();
		System.out.println (ldt);

		LocalDateTime ldt2 = ldt.withDayOfMonth (10);
		System.out.println (ldt2);

		LocalDateTime ldt3 = ldt.with (TemporalAdjusters.next (DayOfWeek.SUNDAY));
		System.out.println (ldt3);
		//自定义：下一个工作日。
		LocalDateTime ldt5 = ldt.with ((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;

			DayOfWeek day = ldt4.getDayOfWeek ();

			if (day.equals (DayOfWeek.FRIDAY)) {
				return ldt4.plusDays (3);
			} else if (day.equals (DayOfWeek.SATURDAY)) {
				return ldt4.plusDays (2);
			} else {
				return ldt4.plusDays (1);
			}
		});

		System.out.println (ldt5);
	}

	/*
	 * Duration:计算两个时间之间的间隔
	 * Period:计算两个日期之间的间隔
	 * */
	@Test
	public void test4() {
		LocalDate ld1 = LocalDate.of (2017, 8, 3);
		LocalDate ld2 = LocalDate.now ();

		Period between = Period.between (ld1, ld2);
		System.out.println (between.getYears ());
		System.out.println (between.getMonths ());
		System.out.println (between.getDays ());
	}

	@Test
	public void test3() throws InterruptedException {
		Instant ins1 = Instant.now ();
		Thread.sleep (1000);

		Instant ins2 = Instant.now ();
		Duration between = Duration.between (ins1, ins2);
		System.out.println (between.toMillis ());

		System.out.println ("----------时间------");

		LocalTime localTime = LocalTime.now ();
		Thread.sleep (1000);
		LocalTime localTime1 = LocalTime.now ();
		Duration between1 = Duration.between (localTime, localTime1);
		System.out.println (between.toMillis ());

	}

	//2.Instant:时间戳 (Unix元年：1970年1月1日00：00：00之间的毫秒值)
	@Test
	public void test2() {
		Instant now = Instant.now ();
		System.out.println (now);//默认获取的是UTC时区（世界协调时间）
		OffsetDateTime offsetDateTime = now.atOffset (ZoneOffset.ofHours (8));
		System.out.println (offsetDateTime);

		System.out.println (now.toEpochMilli ());

		Instant instant = Instant.ofEpochSecond (10);
		System.out.println (instant);
	}

	//1.LocalDate LocalTime LocalDateTime使用方式一样
	@Test
	public void test1() {
		LocalDateTime now = LocalDateTime.now ();
		System.out.println (now);

		LocalDateTime time = LocalDateTime.of (2018, 10, 19, 13, 22, 33);
		System.out.println (time);

		//对时间进行运算
		LocalDateTime time1 = time.plusYears (2);

		System.out.println (time1);

		LocalDateTime time2 = time1.minusYears (1);
		System.out.println (time2);

		System.out.println (time2.getMonth ());
		System.out.println (time2.getDayOfMonth ());

	}
}
