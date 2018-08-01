package java8.Stream.streamdemo;

import java8.Lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * java8.Stream
 *
 * @author jh
 * @date 2018/8/1 19:22
 * description:Stream API的小练习
 */
public class StreamDemo {
	/**
	 * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表尼？
	 * 给定【1,2,3,4,5】，应该返回【1,4,9，,16,25】
	 */
	@Test
	public void test1() {
		Integer[] nums=new Integer[]{1,2,3,4,5};
		Arrays.stream (nums)
				.map ((x)->x*x)
				.forEach (System.out::println);

	}

	/**
	 * 怎样用map和reduce方法数一下流中有多少个Employee？
	 * */
	List<Employee> emps = Arrays.asList (
			new Employee ("张三", 18, 9999.99, Employee.Status.FREE),
			new Employee ("李四", 66, 2345.3, Employee.Status.BUSY),
			new Employee ("壮壮", 37, 6666.99, Employee.Status.VOCATION),
			new Employee ("江浩", 37, 5555.55, Employee.Status.BUSY),
			new Employee ("江浩", 37, 5555.55, Employee.Status.FREE),
			new Employee ("赵四", 12, 7777.77, Employee.Status.FREE)
	);
	@Test
	public  void test2(){
		Optional<Integer> count = emps.stream ()
				.map ((e) -> 1)
				.reduce (Integer::sum);
		System.out.println (count.get ());

	}
	/**
	 *
	 * */

}
