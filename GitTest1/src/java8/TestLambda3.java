package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 12:14
 * description:java8中内置的四大核心函数式接口
 * 1.Consumer<T>    消费型接口
 * void accept(T t);
 * 2.Supplier<T>    供给型接口
 * T get();
 * 3.Function<T,R>  函数型接口
 * R apply(T t);
 * 4.Predicate      断言型接口
 * boolean test(T t)
 */
public class TestLambda3 {

	//Consumer<T>    消费型接口：

	@Test
	public void test() {
		happy (1000, (m) -> System.out.println ("邓禹喜欢大宝剑：消费了" + m + "元"));
	}

	public void happy(double money, Consumer<Double> con) {
		con.accept (money);
	}

	//Supplier<T>    供给型接口：产生对象

	@Test
	public void test2() {
		//需求：产生一些整数，并放入集合。
		List<Integer> list = getNumList (10, () -> (int) (Math.random () * 100));

		for (Integer integer : list) {
			System.out.println (integer);
		}
	}

	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<> ();
		for (int i = 0; i < num; i++) {
			Integer integer = sup.get ();
			list.add (integer);
		}
		return list;
	}

	//Function<T,R>  函数型接口
	// 用于处理字符串

	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply (str);
	}

	@Test
	public void test3() {
		String s = strHandler ("\t\t  hello   ", (str) -> str.trim ());
		System.out.println (s);

		System.out.println (strHandler (s, (str) -> str.substring (2, 5)));
	}

	//Predicate      断言型接口
	//需求：处理字符串---->将满足条件的字符串添加到集合中去

	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<> ();
		for (String s : list) {
			if (pre.test (s)) {
				strList.add (s);
			}
		}
		return strList;
	}

	@Test
	public void test4() {
		List<String> list=Arrays.asList (
				"aa","ccasdc","zc","adasdd","zx","zxca"
		);
		List<String> list1 = filterStr (list, (s) -> s.length () >= 3);
		for (String s : list1) {
			System.out.println (s);
		}
	}
}
