package java8.interfaceTest;

/**
 * java8.interfaceTest
 *
 * @author jh
 * @date 2018/8/3 16:37
 * description:
 */
public interface MyFun {
	/*
	* 全局静态常量和抽象方法
	* java8中可以有默认方法，用defalt修饰符去修饰
	* */

	default String getName(){
		return "MyFun";
	}
	public static void show(){
		System.out.println ("接口中的静态方法");
	}

}
