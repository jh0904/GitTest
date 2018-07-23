package cn.thread1;

public class SetThread implements Runnable {

	private Student s;
	private int x = 0;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				if (x % 2 == 0) {
					s.name = "林青霞";
					s.age = 27;
				} else {
					s.name = "刘意";
					s.age = 30;
				}
				x++;
			}
		}
	}
}
