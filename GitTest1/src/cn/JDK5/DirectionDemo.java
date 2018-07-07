package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:12
 * description:
 */
public class DirectionDemo {
    public static void main(String[] args) {
        Direction d = Direction.FRONT;
        System.out.println (d);
        String name = d.getName ();
        System.out.println (name);

        Direction d1 = Direction.RIGHT;
        System.out.println (d1);
        String name1 = d1.getName ();
        System.out.println (name1);

    }

}
