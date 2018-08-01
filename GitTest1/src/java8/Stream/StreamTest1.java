package java8.Stream;

import java8.Lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * java8.Stream
 *
 * @author jh
 * @date 2018/8/1 14:15
 * description:
 * 一、Stream的三个操作步骤
 * 1.创建
 * --------四种方式获取流
 * 2.中间操作
 * ---------筛选与切片、映射、排序
 * 3.终止操作
 */
public class StreamTest1 {

	List<Employee> employees = Arrays.asList (
			new Employee ("张三", 18, 9999.99),
			new Employee ("李四", 48, 2345.3),
			new Employee ("壮壮", 37, 6666.99),
			new Employee ("江浩", 37, 5555.55),
			new Employee ("江浩", 37, 5555.55),
			new Employee ("江浩", 27, 5555.55),
			new Employee ("江浩", 37, 5555.55),
			new Employee ("赵四", 12, 7777.77)

	);

	/**
	 * 排序：
	 * sorted()--->自然排序(Comparable)
	 * sorted(Comparator com)--->定制排序(Comparator)
	 */
	@Test
	public void test7() {
		List<String> list = Arrays.asList ("aaa", "bbb", "ccc", "ddd", "eee");
		list.stream ()
				.sorted ()
				.forEach (System.out::println);

		System.out.println ("---------------------------");

		employees.stream ()
				.sorted ((e1, e2) -> {
					if (e1.getAge () == e2.getAge ()) {
						return e1.getName ().compareTo (e2.getName ());
					} else {
						return e1.getAge ().compareTo (e2.getAge ());
					}
				})
				.forEach (System.out::println);
	}

	/**
	 * 映射：
	 * map(Function f)
	 * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * mapToDouble(ToDoubleFunction f)
	 * 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
	 * mapToInt(ToIntFunction f)
	 * 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
	 * mapToLong(ToLongFunction f)
	 * 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 LongStream。
	 * flatMap(Function f)
	 * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 * <p>
	 * <p>
	 * map和flatMap就类似于集合的add方法和addAll，一个是加流，一个是吧流里面的所有元素加到其中
	 */
	@Test
	public void test6() {
		List<String> list = Arrays.asList ("aaa", "bbb", "ccc", "ddd", "eee");
		list.stream ()
				.map (String::toUpperCase)
				.forEach (System.out::println);

		System.out.println ("----------------------");

		employees.stream ()
				.map (Employee::getName)
				.forEach (System.out::println);
		/*System.out.println ("---------双层foreach-------------");
		Stream<Stream<Character>> stream = list.stream ().map (StreamTest1::filterCharacter);
		//流中的流，最里面是Character
		stream.forEach ((sm) -> sm.forEach (System.out::println));*/
		System.out.println ("-------------flatMap(Function f)---------");
		Stream<Character> characterStream = list.stream ().
				flatMap (StreamTest1::filterCharacter);
		characterStream
				.forEach (System.out::println);

	}

	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<> ();
		for (Character c : str.toCharArray ()) {
			list.add (c);
		}
		return list.stream ();
	}

	/**
	 * 筛选与切片
	 * filter(Predicate p p) )
	 * 接收 Lambda ， 从流中排除某些元素。
	 * distinct()
	 * 筛选，通过流所生成元素的 hashCode() 和 equals() 去
	 * 除重复元素
	 * limit(long maxSize)
	 * 截断流，使其元素不超过给定数量。
	 * skip(long n)
	 * 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
	 * 不足 n 个，则返回一个空流。与 limit(n) 互补
	 */

	@Test
	public void test5() {
		//去除重复,必须要重写hashCode() 和 equals()
		employees.stream ()
				.filter ((e) -> e.getSalary () > 5000)
				.distinct ()
				.skip (2)
				.forEach (System.out::println);
	}

	@Test
	public void test4() {
		//跳过前两个
		employees.stream ()
				.filter ((e) -> e.getSalary () > 5000)
				.skip (2)
				.forEach (System.out::println);
	}

	@Test
	public void test3() {
		//只取两个
		employees.stream ()
				.filter ((e) -> {
					System.out.println ("短路");
					return e.getSalary () > 5000;
				})
				.limit (2)
				.forEach (System.out::println);
	}

	//内部迭代，有内部API完成操作

	@Test
	public void test1() {
		//中间操作（不执行终止操作，中间操作也不操作，这个叫惰性求值/延迟加载）
		Stream<Employee> stream = employees.stream ()
				.filter ((e) -> {
					System.out.println ("Stream API");
					return e.getAge () > 35;
				});
		//终止操作 一次性执行全部内容
		stream.forEach (System.out::println);
	}

	//外部迭代

	@Test
	public void test2() {
		Iterator<Employee> iterator = employees.iterator ();
		while (iterator.hasNext ()) {
			System.out.println (iterator.next ());
		}
	}
}
