package java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 16:25
 * description: 方法引用：如果lambda中的内容已经有方法已经实现了，我们可以使用方法引用
 * 方法引用是lambda另外一种表现形式。
 * 三种语法格式
 * 对象::示例方法名
 * 类::静态方法名
 * 类::示例方法名
 * 注意：
 * 1.Lambda方法体中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致。
 * 2.若lambda参数列表中是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用    类::示例方法名
 * <p>
 * 二、构造器引用：
 * 格式：
 * ClassName::new
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * 三、数组引用
 * Type::new
 */
public class TestMethodRef {
	//      对象::示例方法名

	@Test
	public void test1() {
		Consumer<String> con = (x) -> System.out.println (x);

		Consumer<String> con1 = System.out::println;
		con1.accept ("asdasd");

		/*参数列表和返回值类型一致*/
	}

	@Test
	public void test2() {
		Employee e = new Employee ();
		//Supplier<String> sup=()->e.getName ();
		Supplier<String> sup = e::getName;
		String s = sup.get ();
		System.out.println (s);

		Supplier<Integer> sup2 = e::getAge;
		Integer integer = sup2.get ();
		System.out.println (integer);
	}

	//类::静态方法名

	@Test
	public void test3() {
		//Comparator<Integer> com=(x,y)->Integer.compare (x,y);
		Comparator<Integer> com = Integer::compare;
		int compare = com.compare (2, 3);
		System.out.println (compare);
	}

	//类::实例方法名

	@Test
	public void test4() {
		//比较两个字符串是否一致，返回boolean值
		//BiPredicate <String,String>bip=(x,y)->x.equals (y);
		BiPredicate<String, String> bip = String::equals;
		System.out.println (bip.test ("abc", "ab"));
	}

	//构造器引用

	@Test
	public void test5() {
		//Supplier<Employee> sup=()->new Employee ();
		//构造器引用实现，如下：
		Supplier<Employee> sup = Employee::new;
		Employee employee = sup.get ();
		System.out.println (employee);

	}

	@Test
	public void test6() {
		Function<String, Employee> fun = Employee::new;
		Employee e = fun.apply ("蒋浩");
		System.out.println (e);

		BiFunction<Integer, Integer, Employee> bif = Employee::new;
		Employee apply = bif.apply (1, 22);
		System.out.println (apply);
	}


	//数组引用

	@Test
	public void test7(){
		Function<Integer,String[]> fun=(x)->new String [x];
		String[] apply = fun.apply (10);
		System.out.println (apply.length);

		Function<Integer,String[]> fun1= String[]::new;
		String[] apply1 = fun.apply (55);
		System.out.println (apply1.length);

	}
}
