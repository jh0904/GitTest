package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:57
 * description:
 */
public enum MyDirection {
    /*方向枚举*/
    FRONT("前"),LATER("后"),LEFT("左"),RIGHT("右");

    private String name;

    private  MyDirection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
