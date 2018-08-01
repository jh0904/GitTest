package java8.Lambda;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 8:49
 * description:
 */
public class FilterEmployeeByAge implements MyPredicate<Employee>{
	@Override
	public boolean test(Employee employee) {
		return employee.getAge ()>=25;
	}
	//其他的过滤就重写一个类。实现接口。
}
