package java8.Lambda;

import java.util.Objects;

/**
 * java8
 *
 * @author jh
 * @date 2018/7/31 8:36
 * description:创建一个简单的实体类
 */
public class Employee {
	private Integer id;
	private String name;
	private int age;
	private double salary;
	private Status status;

	public Employee() {
		super ();
	}

	public Employee(String name) {
		this.name = name;
	}


	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(int id, int age) {
		this.id = id;
		this.age = age;
	}

	public Employee( String name, int age, double salary, Status status) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
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
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", status=" + status +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass () != o.getClass ()) return false;
		Employee employee = (Employee) o;
		return id == employee.id &&
				age == employee.age &&
				Double.compare (employee.salary, salary) == 0 &&
				Objects.equals (name, employee.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash (id, name, age, salary);
	}
	public enum Status{
		FREE,
		BUSY,
		VOCATION
	}
}
