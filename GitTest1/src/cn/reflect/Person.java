package cn.reflect;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:16
 * description:
 */
public class Person {
    private String name;
    int age;
    public String address;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public void show(){
        System.out.println ("show");
    }

    public Person() {
    }

    public void method(String s){
        System.out.println ("method-->"+s);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
