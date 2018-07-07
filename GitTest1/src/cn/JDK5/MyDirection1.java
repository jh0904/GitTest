package cn.JDK5;

/**
 * cn.JDK5
 *
 * @author jh
 * @date 2018/7/7 14:57
 * description:
 */
public enum MyDirection1 {
    /*方向枚举*/
    FRONT("前"){
        @Override
        public void show(){
            System.out.println ("前");
        }
    },LATER("后"){
        @Override
        public void show(){
            System.out.println ("后");
        }
    },LEFT("左"){
        @Override
        public void show(){
            System.out.println ("左");
        }
    },RIGHT("右"){
        @Override
        public void show(){
            System.out.println ("右");
        }
    };

    private String name;

    private MyDirection1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void show();
}
