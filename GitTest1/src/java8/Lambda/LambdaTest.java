package java8.Lambda;

import org.junit.Test;

import java.util.*;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 8:28
 * description:学习简单的Lambda表达式
 */
public class LambdaTest {
	@Test
	public void test1() {
		//原来的匿名内部类
		Comparator<Integer> com = new Comparator<> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare (o1, o2);
			}
		};

		TreeSet<Integer> ts = new TreeSet<> (com);
	}

	@Test
	public void test2() {
		//lambda表达式解决
		Comparator<Integer> com = (x, y) -> Integer.compare (x, y);

		TreeSet<Integer> ts = new TreeSet<> (com);
	}

	List<Employee> employees = Arrays.asList (
			new Employee ("张三", 18, 9999.99),
			new Employee ("李四", 48, 2345.3),
			new Employee ("壮壮", 37, 6666.99),
			new Employee ("江浩", 74, 5555.55),
			new Employee ("赵四", 12, 7777.77)
	);
	//获取公司中员工年龄大于35的员工信息

	public List<Employee> filterEmployee(List<Employee> list) {
		List<Employee> emps = new ArrayList<> ();
		for (Employee emp : list) {
			if (emp.getAge () >= 35) {
				emps.add (emp);
			}
		}
		return emps;
	}

	@Test
	public void test3() {
		List<Employee> list = filterEmployee (this.employees);
		for (Employee employee : list) {
			System.out.println (employee);
		}

	}

	//需求:工资大于5000的员工信息

	/**
	 * 两个方法区别只在于if(emp.getSalary ()>=5000){
	 * 判断条件不同，产生冗余代码；
	 */
	public List<Employee> filterEmployee2(List<Employee> list) {
		List<Employee> emps = new ArrayList<> ();
		for (Employee emp : list) {
			if (emp.getSalary () >= 5000) {
				emps.add (emp);
			}
		}
		return emps;
	}

	//优化方式：采用设计模式(策略设计模式)

	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
		List<Employee> emps = new ArrayList<> ();
		for (Employee employee : list) {
			if (mp.test (employee)) {
				emps.add (employee);
			}
		}
		return emps;
	}

	@Test
	public void test4() {
		List<Employee> list = filterEmployee (this.employees, new FilterEmployeeByAge ());
		for (Employee employee : list) {
			System.out.println (employee);
		}

	}

	//优化方式2：匿名内部类

	@Test
	public void test5() {
		List<Employee> list = filterEmployee (this.employees, new MyPredicate<Employee> () {
			@Override
			public boolean test(Employee employee) {
				return employee.getSalary () >= 5000;
			}
		});

		for (Employee employee : list) {
			System.out.println (employee);
		}
	}

//优化方式3：使用lambda表达式

	@Test
	public void test6(){

		List<Employee> list = filterEmployee (this.employees, (e) -> e.getSalary () >= 5000);

		list.forEach (System.out::println);
	}
//优化方式4：lambda表达式和Stream API组合运用

	@Test
	public void test7(){
			employees.stream ().filter ((e)->e.getSalary ()>=5000).limit (2).forEach (System.out::println);

		System.out.println ("-------------------------");

		//遍历所有的名字Stream API
		employees.stream ().map (Employee::getName).forEach (System.out::println);
	}
}
