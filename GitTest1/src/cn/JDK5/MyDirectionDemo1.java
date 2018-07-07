package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:12
 * description:
 */
public class MyDirectionDemo1 {
    public static void main(String[] args) {
        MyDirection1 d = MyDirection1.FRONT;
        System.out.println (d.getName ());
        d.show ();
        System.out.println ("----------------");
        d=MyDirection1.LEFT;
        switch (d) {
            case FRONT:
                System.out.println ("你选择了前");
                break;
            case LATER:
                System.out.println ("你选择了后");
                break;
            case RIGHT:
                System.out.println ("你选择了右");
                break;
            case LEFT:
                System.out.println ("你选择了左");
                break;
            default:
                break;
        }
    }

}
