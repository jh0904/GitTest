package java8.timetest;

import org.junit.Test;

import javax.swing.plaf.basic.BasicTextAreaUI;
import java.time.*;

/**
 * java8.timetest
 *
 * @author jh
 * @date 2018/8/3 18:13
 * description:
 */
public class TestLocalTime {
	/*
	 * Duration:计算两个时间之间的间隔
	 * Period:计算两个日期之间的间隔
	 * */
	@Test
	public void test4(){
		LocalDate ld1 = LocalDate.of (2017,8,3);
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
