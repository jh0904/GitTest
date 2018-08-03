package java8.interfaceTest;

/**
 * java8.interfaceTest
 *
 * @author jh
 * @date 2018/8/3 16:54
 * description:
 */
public class SubClass  implements MyFun,MyFun2{

	@Override
	public String getName() {
		return MyFun.super.getName ();
	}
}
