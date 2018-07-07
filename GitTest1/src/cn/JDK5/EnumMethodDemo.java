package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 15:41
 * description:
 */
public class EnumMethodDemo {
    public static void main(String[] args) {
        MyDirection1 d=MyDirection1.LATER;
        MyDirection1 d1 = MyDirection1.FRONT;

        String name = d1.name ();
        System.out.println (name);

        MyDirection1[] values = MyDirection1.values ();
        for (MyDirection1 value : values) {
            System.out.println (value);
        }
        

    }
}
