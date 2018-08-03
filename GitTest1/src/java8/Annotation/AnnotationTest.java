package java8.Annotation;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * java8.Annotation
 *
 * @author jh
 * @date 2018/8/3 23:00
 * description:
 */
public class AnnotationTest {

	private @NotNull Object obj=null;

	@Test
	public void test1() throws NoSuchMethodException {
		Class<AnnotationTest> clazz = AnnotationTest.class;
		Method m1 = clazz.getMethod ("show");

		MyAnnotation[] ma = m1.getAnnotationsByType (MyAnnotation.class);

		for (MyAnnotation myAnnotation : ma) {
			System.out.println (myAnnotation);
		}

	}

	@MyAnnotation("hello")
	@MyAnnotation("world")
	public void show(@MyAnnotation("abc") String str){

	}
}
