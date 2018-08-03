package java8.optional;

/**
 * java8.optional
 *
 * @author jh
 * @date 2018/8/3 16:10
 * description:
 */
public class Man {
	private Goddess goddess;

	public Man() {
	}

	public Man(Goddess goddess) {
		this.goddess = goddess;
	}

	public Goddess getGoddess() {
		return goddess;
	}

	public void setGoddess(Goddess goddess) {
		this.goddess = goddess;
	}

	@Override
	public String toString() {
		return "Man{" +
				"goddess=" + goddess +
				'}';
	}
}


