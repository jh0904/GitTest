package java8.interfaceTest;

/**
 * java8.interfaceTest
 *
 * @author jh
 * @date 2018/8/3 16:55
 * description:
 */
public class DefaultInterfaceTest {
	public static void main(String[] args) {
		SubClass sc = new SubClass ();
		System.out.println (sc.getName ());
		/**
		 * 类优先
		 * 实现两个接口，报错了
		 * */

		MyFun.show ();
	}
}
