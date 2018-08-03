package java8.fork_join;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * java8.fork_join
 *
 * @author jh
 * @date 2018/8/2 18:27
 * description:
 */
public class FockJoinTest {

	/**
	 * FockJoin框架
	 * */
	@Test
	public void test1() {
		Instant start = Instant.now ();

		ForkJoinPool pool = new ForkJoinPool ();
		ForkJoinTask<Long> task = new ForkJoinCalculate (0, 1000000000L);
		Long sum = pool.invoke (task);
		System.out.println (sum);

		Instant end = Instant.now ();

		System.out.println ("耗费时间：" + Duration.between (start, end).toMillis ());
	}

	/**
	 * for循环
	 * */
	@Test
	public void test2() {
		Instant start = Instant.now ();
		long sum=0;
		for (long i = 0; i <= 1000000000L; i++) {
			sum += i;
		}
		System.out.println (sum);

		Instant end = Instant.now ();

		System.out.println ("耗费时间：" + Duration.between (start, end).toMillis ());
	}

	/**
	 * java8并行流
	 * */
	@Test
	public void test3(){
		Instant start = Instant.now ();
		LongStream.rangeClosed (0,1000000000L)
				.parallel ()
				.reduce (0,Long::sum);

		Instant end = Instant.now ();

		System.out.println ("耗费时间：" + Duration.between (start, end).toMillis ());
	}
}
