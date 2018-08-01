package java8.Stream;

import java8.Lambda.Employee;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * java8.Stream
 *
 * @author jh
 * @date 2018/8/1 13:58
 * description:
 * 一、Stream的三个操作步骤
 * 1.创建
 * --------四种方式获取流
 * 2.中间操作
 * 3.终止操作
 *
 */
public class StreamTest {
	@Test
	public void test1(){
		//1.通过Collection系列提供的stream（）(串行流)或parallelStream（并行流）
		List<String> list=new ArrayList<> ();
		Stream<String> stream1 = list.stream ();
		//2.通过Arrays中的静态方法stream（）获取数组流
		Employee[] employees=new Employee[10];
		Stream<Employee> stream2 = Arrays.stream (employees);
		//3.通过Stream静态方法of()
		Stream<String> stream3 = Stream.of ("aa", "bb", "cc");
		//4.创建无限流
		//迭代
		Stream<Integer> stream4 = Stream.iterate (0, (x) -> x + 2);
		stream4.limit (10).forEach (System.out::println);
		//生成
		Stream.generate (Math::random).limit (5).forEach (System.out::println);
	}
}
