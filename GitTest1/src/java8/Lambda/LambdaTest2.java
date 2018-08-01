package java8.Lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 9:35
 * description:
 * Lambda表达式的基本语法：
 * java8中引入了一个新的操作符"->"，这个操作符称为箭头操作符或者Lambda操作符。
 * 箭头操作符讲过Lambda拆分成两部分
 * 左侧：对于Lambda表达式的参数列表  (接口中抽象方法的参数列表)
 * 右侧：Lambda中需要执行的操作，即Lambda体  （对抽象方法实现）
 * <p>
 * 语法格式一：无参数/无返回值的方法
 * () -> System.out.println("Hello Lambda!");
 * 语法格式二：一个参数，无返回值。
 * （x） -> System.out.println(x);
 * System.out::println;
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x);
 * 语法格式四：两个参数，有返回值，并且Lambda表达式中有多条语句。
 * Comparator<Integer> con = (x, y) -> {
 * System.out.println ("函数式接口");
 * return Integer.compare (x, y);
 * };
 * 语法格式五：两个参数，有返回值，Lambda表达式中有一条语句。，retrun和P{}都可以不写。
 * Comparator<Integer> con = (x, y) -> Integer.compare (x, y);
 * IDEA推荐使用这个------>Integer::compare
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器
 * 通过上下文推出数据类型  ”数据推断“
 * (Integer x,Integer y) -> Integer.compare (x, y);
 * <p>
 * <p>
 * 总结：Lambda表达式   左右遇一，括号省，
 * 左侧推断，类型省，
 * <p>
 * <p>
 * 二：Lambda表达式需要”函数式接口“的支持
 * 函数式接口:接口中只有一个抽象方法，称为函数式接口。比如MyPredicate，
 * 可以使用注解@FunctionalInterface,可以检查是否式函数式接口
 */
public class LambdaTest2 {
	@Test
	public void test1() {
		Runnable r = new Runnable () {
			@Override
			public void run() {
				System.out.println ("Hello World");
			}
		};

		r.run ();
		System.out.println ("--------------------");

		Runnable r1 = () -> System.out.println ("Hello Lambda!");

		r1.run ();
	}

	@Test
	public void test2() {
		//可以省略小括号
		Consumer<String> con = x -> System.out.println (x);
		con.accept ("学习java8");
	}

	@Test
	public void test3() {
		Comparator<Integer> con = (x, y) -> {
			System.out.println ("函数式接口");
			return Integer.compare (x, y);
		};
	}

	@Test
	public void test4() {
		Comparator<Integer> con = (x, y) -> Integer.compare (x, y);
		//Integer::compare
	}

	@Test
	public void test5() {
		//数据推断
		String[] strs = {"aaa", "bbb", "ccc"};
		//拆开写不可以

		List<String> list = new ArrayList<> ();

		//可以不用写泛型JDK1.8才可以
		show (new HashMap<> ());
	}

	public void show(Map<String, Integer> map) {

	}

	//需求：对一个数进行运算
	@Test
	public void test6() {
		Integer num = operation (100, (x) -> x * x);
		System.out.println (num);

		System.out.println (operation (200,(y)->y+200));
	}

	public Integer operation(Integer num, MyFun mf) {
		return mf.getValue (num);
	}

}
