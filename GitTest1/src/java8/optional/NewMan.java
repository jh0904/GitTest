package java8.optional;

import java.util.Optional;

/**
 * java8.optional
 *
 * @author jh
 * @date 2018/8/3 16:22
 * description:
 */
public class NewMan {
	private Optional<Goddess> goddess = Optional.empty ();

	public NewMan() {
	}

	public NewMan(Optional<Goddess> goddess) {
		this.goddess = goddess;
	}

	public Optional<Goddess> getGoddess() {
		return goddess;
	}

	public void setGoddess(Optional<Goddess> goddess) {
		this.goddess = goddess;
	}

	@Override
	public String toString() {
		return "NewMan{" +
				"goddess=" + goddess +
				'}';
	}
}
