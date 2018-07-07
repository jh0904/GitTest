package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:12
 * description:
 */
public class Direction {
    //创建几个示例

    public static final Direction FRONT = new Direction ("前");
    public static final Direction LATER = new Direction ("后");
    public static final Direction LEFT = new Direction ("左");
    public static final Direction RIGHT = new Direction ("右");

/*    private Direction() {
    }*/

    private Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
