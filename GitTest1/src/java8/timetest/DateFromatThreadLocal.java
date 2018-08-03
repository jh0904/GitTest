package java8.timetest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java8.timetest
 *
 * @author jh
 * @date 2018/8/3 17:48
 * description:
 */
public class DateFromatThreadLocal {

	private static final ThreadLocal<DateFormat> df=new ThreadLocal<> (){
		protected DateFormat initialValue(){
			return new SimpleDateFormat ("yyyyMMdd");
		}
	};

	public static Date convert(String source) throws ParseException {
		return df.get ().parse (source);
	}

}
