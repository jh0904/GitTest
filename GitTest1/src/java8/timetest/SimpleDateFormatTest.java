package java8.timetest;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * java8.timetest
 *
 * @author jh
 * @date 2018/8/3 17:40
 * description:传统的时间类，线程不安全
 */
public class SimpleDateFormatTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		/*SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMdd");

		Callable<Date> task = new Callable<> () {
			*//*@Override
			public Date call() throws Exception {
				return sdf.parse ("20180803");
			}*//*
			@Override
			public Date call() throws Exception {
				return DateFromatThreadLocal.convert ("20180803");
			}
		};

		ExecutorService pool = Executors.newFixedThreadPool (10);

		List<Future<Date>> results = new ArrayList<> ();

		for (int i = 0; i < 10; i++) {
			results.add (pool.submit (task));
		}

		for (Future<Date> result : results) {
			System.out.println (result.get ());
		}
		pool.shutdown ();*/

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("yyyyMMdd");


		Callable<LocalDate> task = new Callable<LocalDate> () {
			@Override
			public LocalDate call() throws Exception {
				LocalDate ld = LocalDate.parse("20161121", dtf);
				return ld;
			}
		};

		ExecutorService pool = Executors.newFixedThreadPool (10);

		List<Future<LocalDate>> results = new ArrayList<> ();

		for (int i = 0; i < 10; i++) {
			results.add ( pool.submit (task));
		}

		for (Future<LocalDate> result : results) {
			System.out.println (result.get ());
		}
		pool.shutdown ();
	}
}
