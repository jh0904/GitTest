package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 12:14
 * description:简单联系
 */
public class TestLambda {

	List<Employee> employees = Arrays.asList (
			new Employee ("张三", 18, 9999.99),
			new Employee ("李四", 48, 2345.3),
			new Employee ("壮壮", 37, 6666.99),
			new Employee ("江浩", 37, 5555.55),
			new Employee ("赵四", 12, 7777.77)
	);

	/**
	 * 调用Callections.sort()方法，比较年龄大小，年龄一样按照薪水比较，使用Lambda表达式
	 */
	@Test
	public void test1() {
		Collections.sort (employees, (x, y) -> {
			if (x.getAge () == y.getAge ()) {
				return x.getName ().compareTo (y.getName ());
			} else {
				return -Integer.compare (x.getAge (), y.getAge ());
			}
		});

		for (Employee employee : employees) {
			System.out.println (employee);
		}
	}

	/**
	 * 1.声明函数式接口，接口中声明抽象方法，public String getValue(String str)
	 * 2.声明类TestLambda，类中编写使用接口作为参数，将第一字符串转成大写，并作为其方法返回值
	 * 3.再将一个字符串的第二个和第四个索引位置进行截取字符串
	 */

	public String strHandler(String str, MyFunction mf) {
		return mf.getValue (str);
	}

	@Test
	public void test2() {
		String s = strHandler ("\t\t\t  哈哈哈   ", String::trim);
		System.out.println (s);

		System.out.println ("----------------------------");

		String s1 = strHandler ("aaaabbc", String::toUpperCase);
		System.out.println (s1);
		System.out.println ("----------------------------");

		String s2 = strHandler ("12345", (str) -> str.substring (2, 5));
		System.out.println (s2);
		System.out.println ("----------------------------");
	}

	/**
	 * 1.声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
	 * 2.接口中声明对应的抽象方法
	 * 3.在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
	 * 4.再计算两个long型参数的积
	 */

	//需求：对于两个long型数据进行处理

	public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
		System.out.println (mf.getValue (l1, l2));
	}

	@Test
	public void test3() {
		op (100L, 200L, (x, y) -> x + y);

		op (100L, 200L, (x, y) -> x * y);
	}

}
