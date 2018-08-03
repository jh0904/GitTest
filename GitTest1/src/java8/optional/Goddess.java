package java8.optional;

/**
 * java8.optional
 *
 * @author jh
 * @date 2018/8/3 16:11
 * description:
 */
public class Goddess {
	private String name ;

	public Goddess() {
	}

	public Goddess(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Goddess{" +
				"name='" + name + '\'' +
				'}';
	}
}
