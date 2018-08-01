package java8.Lambda;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 8:49
 * description:
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
}
