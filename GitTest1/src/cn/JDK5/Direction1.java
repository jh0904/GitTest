package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:12
 * description:自己实现枚举类，使用匿名内部类，在使用多态的方式。
 */
public abstract class Direction1 {
    //创建几个示例

    public static final Direction1 FRONT = new Direction1 ("前") {
        @Override
        public void show() {
            System.out.println ("前");
        }
    };
    public static final Direction1 LATER = new Direction1 ("后") {
        @Override
        public void show() {
            System.out.println ("后");
        }
    };
    public static final Direction1 LEFT = new Direction1 ("左") {
        @Override
        public void show() {
            System.out.println ("左");
        }
    };
    public static final Direction1 RIGHT = new Direction1 ("右") {
        @Override
        public void show() {
            System.out.println ("右");
        }
    };

/*    private Direction() {
    }*/

    private Direction1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public abstract void show();
}
