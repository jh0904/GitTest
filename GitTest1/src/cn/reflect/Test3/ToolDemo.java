package cn.reflect.Test3;

/**
 * cn.reflect.Test3
 *
 * @author jh
 * @date 2018/7/6 23:30
 * description:
 */
public class ToolDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p=new Person ();
        Tool t=new Tool ();
        t.setProperty (p,"name","蒋浩");
        t.setProperty (p,"age",27);
        System.out.println (p);
    }

}
class Person{
    private String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}