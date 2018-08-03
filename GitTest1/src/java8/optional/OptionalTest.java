package java8.optional;

import java8.Lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * java8.optional
 *
 * @author jh
 * @date 2018/8/3 15:41
 * description:Optional常用的方法  ----->用于尽量避免空指针异常
 * 一、Optional 容器类：
 * Optional.of(T t) : 创建一个 Optional 实例
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * isPresent() : 判断是否包含值
 * orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class OptionalTest {
	@Test
	public void test4(){
		//map、flatmap
		Optional<Employee> op = Optional.of (new Employee ("zz", 18, 888.88, Employee.Status.BUSY
		));
		/*Optional<String> s = op.map (Employee::getName);

		System.out.println (s.get ());*/

		Optional<String> s = op.flatMap ((e) -> Optional.ofNullable (e.getName ()));
		System.out.println (s.get ());
	}


	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable (null);

		/*if(op.isPresent ()){
			System.out.println (op.get ());
		}*/
		/*Employee zz = op.orElse (new Employee ("zz", 18, 888.88, Employee.Status.BUSY
		));
		System.out.println (zz);*/

		Employee employee = op.orElseGet (() -> new Employee ());//函数式接口（可以自定义功能）
		System.out.println (employee);
	}


		@Test
	public void test2(){
		Optional<Object> op = Optional.empty ();
		System.out.println (op.get ());

	}


	@Test
	public void test1(){
		Optional<Employee> oo = Optional.of (new Employee ());
		Employee employee = oo.get ();
		System.out.println (employee);

	}

	//例题：获取一个男人心中女神的名字

	@Test
	public void test5(){
		//Man man = new Man ();
		Optional<Goddess> gn = Optional.ofNullable (new Goddess ("小泽老师"));
		Optional<NewMan> op = Optional.ofNullable (new NewMan (gn));
		String godnessName = getGodnessName1 (op);
		System.out.println (godnessName);
	}

	public String getGodnessName(Man man){
		if(man!=null){
			Goddess goddess = man.getGoddess ();
			if(goddess!=null){
				return goddess.getName ();
			}
		}
		return "仓老师";
	}

	public String getGodnessName1(Optional<NewMan> man){
		return man.orElse (new NewMan ())
				.getGoddess ()
				.orElse (new Goddess ("波老师"))
				.getName ();
	}

}
