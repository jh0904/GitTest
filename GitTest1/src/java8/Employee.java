package java8;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 8:36
 * description:创建一个简单的实体类
 */
public class Employee {
	private String name;
	private int age;
	private double salary;

	public Employee() {
		super ();
	}

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				'}';
	}
}
