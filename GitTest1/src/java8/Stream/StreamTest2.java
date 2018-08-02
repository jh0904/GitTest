package java8.Stream;

import java8.Lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8.Stream
 *
 * @author jh
 * @date 2018/8/1 13:58
 * description:
 * 一、Stream的三个操作步骤
 * 1.创建
 * 2.中间操作
 * 3.终止操作----
 * -------
 */

public class StreamTest2 {
	List<Employee> employees = Arrays.asList (
			new Employee ("张三", 18, 9999.99, Employee.Status.FREE),
			new Employee ("李四", 66, 2345.3, Employee.Status.BUSY),
			new Employee ("壮壮", 37, 6666.99, Employee.Status.VOCATION),
			new Employee ("江浩", 37, 5555.55, Employee.Status.BUSY),
			new Employee ("江浩", 37, 5555.55, Employee.Status.FREE),
			new Employee ("赵四", 12, 7777.77, Employee.Status.FREE)
	);

	/**
	 * 收集：
	 * collect---将流转化成其他形式。
	 */
	@Test
	public void test10(){
		String collect = employees.stream ()
				.map (Employee::getName)
				.collect (Collectors.joining (","));
		System.out.println (collect);
	}


	@Test
	public void test9(){
		DoubleSummaryStatistics dss = employees.stream ()
				.collect (Collectors.summarizingDouble (Employee::getSalary));
		System.out.println (dss.getMin ());
	}


	//分区
	@Test
	public void test8(){
		Map<Boolean, List<Employee>> map = employees.stream ()
				.collect (Collectors.partitioningBy ((e) -> e.getSalary () > 8000));

		System.out.println (map);
	}


	//多级分组
	@Test
	public void test7() {
		Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream ()
				.collect (Collectors.groupingBy (Employee::getStatus, Collectors.groupingBy ((e) -> {
					if (e.getAge () <= 35) {
						return "青年";
					} else if (e.getAge () <= 50) {
						return "中年";
					} else {
						return "老年";
					}
				})));

		System.out.println (collect);
	}

	//分组
	@Test
	public void test6() {
		Map<Employee.Status, List<Employee>> map = employees.stream ()
				.collect (Collectors.groupingBy (Employee::getStatus));
		Set<Employee.Status> set = map.keySet ();
		for (Employee.Status status : set) {
			System.out.println (map.get (status));
		}
	}

	@Test
	public void test5() {
		Long aLong = employees.stream ()
				.collect (Collectors.counting ());
		System.out.println (aLong);
		//平均值
		Double collect = employees.stream ()
				.collect (Collectors.averagingDouble (Employee::getSalary));
		System.out.println (collect);
		//总和
		Double collect1 = employees.stream ()
				.collect (Collectors.summingDouble (Employee::getSalary));
		System.out.println (collect1);
		//最大值
		Optional<Employee> collect2 = employees.stream ()
				.collect (Collectors.maxBy ((e1, e2) -> Double.compare (e1.getSalary (), e2.getSalary ())));
		System.out.println (collect2.get ());
		//最小值
		Optional<Double> collect3 = employees.stream ()
				.map (Employee::getSalary)
				.collect (Collectors.minBy (Double::compare));

		System.out.println (collect3.get ());

		Optional<Employee> collect4 = employees.stream ().min (Comparator.comparingDouble (Employee::getSalary));
		System.out.println (collect4.get ());
	}

	@Test
	public void test4() {
		List<String> list = employees.stream ()
				.map (Employee::getName)
				.collect (Collectors.toList ());

		list.forEach (System.out::println);
		System.out.println ("------------------");
		Set<String> set = employees.stream ()
				.map (Employee::getName)
				.collect (Collectors.toSet ());

		set.forEach (System.out::println);

		System.out.println ("------------------");

		HashSet<String> hashSet = employees.stream ()
				.map (Employee::getName)
				.collect (Collectors.toCollection (HashSet::new));
		hashSet.forEach (System.out::println);

	}

	/**
	 * 归约
	 * reduce(T iden, BinaryOperator b)可以将流中元素反复结合起来，得到一个值。返回 T
	 */
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList (1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream ()
				.reduce (0, (x, y) -> x + y);
		System.out.println (sum);

		System.out.println ("----------------------");
		//有可能为空，所以返回Optional

		Optional<Double> op = employees.stream ()
				.map (Employee::getSalary)
				.reduce (Double::sum);
		/*
		 * map用来提取数据
		 * reduce用来归约处理
		 * */
		System.out.println (op.get ());

		/*
		* map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它
		来进行网络搜索而出名。
		* */
	}

	/**
	 * 查找与匹配
	 * allMatch(Predicate p)
	 * 检查是否匹配所有元素
	 * anyMatch( (Predicate p) )
	 * 检查是否至少匹配一个元素
	 * noneMatch(Predicate p)
	 * 检查是否没有匹配所有元素
	 * findFirst()
	 * 返回第一个元素
	 * findAny()
	 * 返回当前流中的任意元素
	 * count()
	 * 返回流中元素总数
	 * r max(Comparator c c) )
	 * 返回流中最大值
	 * r min(Comparator c c) )
	 * 返回流中最小值
	 * forEach(Consumer c c) )
	 * 内部迭代( (用 使用 Collection 接口需要用户去做迭代，称为 外部迭代 。相反， Stream API 使用内部
	 * 迭代 —— 它帮你把迭代做了) )
	 */

	@Test
	public void test2() {
		Long count = (Long) employees.stream ()
				.count ();
		System.out.println (count);

		Optional<Employee> max = employees.stream ()
				.max (Comparator.comparingDouble (Employee::getSalary));
		System.out.println (max.get ());

		Optional<Double> min = employees.stream ()
				.map (Employee::getSalary)
				.min (Double::compare);
		System.out.println (min.get ());
	}

	@Test
	public void test() {
		//allMatch匹配所有元素
		boolean b = employees.stream ()
				.allMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));
		System.out.println (b);

		//anyMatch是否有一个条件满足
		boolean b1 = employees.stream ()
				.anyMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));
		System.out.println (b1);
		//noneMatch  没有匹配所有元素
		boolean b2 = employees.stream ()
				.noneMatch ((e) -> e.getStatus ().equals (Employee.Status.BUSY));
		System.out.println (b2);

		//
		Optional<Employee> op = employees.stream ()
				.sorted (Comparator.comparingDouble (Employee::getSalary))
				.findFirst ();
		System.out.println (op.get ());

		System.out.println ("----------------------");

		Optional<Employee> op2 = employees.parallelStream ()
				.filter ((e) -> e.getStatus ().equals (Employee.Status.FREE)).findAny ();
		System.out.println (op2.get ());

	}
}
