package java8;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 15:06
 * description:
 */
@FunctionalInterface
public interface MyFunction2<T,R> {

	public R getValue(T t1,T t2);
}
