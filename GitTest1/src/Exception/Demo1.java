package Exception;

/**
 * Exception
 *
 * @author jh
 * @date 2018/7/31 20:26
 * description:
 */
public class Demo1 {
	public static int testFinally1(){
		int result=1;
		try {
			result=2;
			return  result;
		} catch (Exception e) {
			return 0;
		} finally {
			result=3;
			System.out.println ("testFinally1");
		}
	}
	public static StringBuffer testFinally2(){
		StringBuffer s=new StringBuffer ("hello");
		try {
			return s;
		} catch (Exception e) {
			return null;
		} finally {
			s.append ("world");
			System.out.println ("testFinally2");
		}
	}


	public static void main(String[] args) {
		int i = testFinally1 ();
		System.out.println (i);
		StringBuffer finally2 = testFinally2 ();
		System.out.println (finally2);
	}
}
