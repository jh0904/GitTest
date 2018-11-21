package Outer;

/**
 * Outer
 *
 * @author jh
 * @date 2018/11/13 22:59
 * description:
 */
public class OuterClass {
	//成员内部类
	private class InstanceInnerClass {
	}

	//静态内部类
	static class StaticInnerClass {
	}

	public static void main(String[] args) {
		//匿名内部类
		(new Thread () {
		}).start ();
		(new Thread () {
		}).start ();
		//方法内部类
		class MethodClass1 {
		}
		class MethodClass2 {
		}
	}
}
