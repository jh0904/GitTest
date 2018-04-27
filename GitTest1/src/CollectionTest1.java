import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest1 {
    public static void main(String[] args) {
        Collection c=new ArrayList ();
        c.add ("asd1");
        c.add ("asd2");
        c.add ("asd3");
        c.add ("asd4");
        Collection c1=new ArrayList ();
        c1.add ("asd4");
        c1.add ("asd5");
        c1.add ("asd6");
        c1.add ("asd7");
        /*测试All方法(谁调用谁改变)*/


        //boolean addAll(Collection<? extends E> c)
        /* boolean b = c.addAll (c1);//把后一个全部添加到第一个，重复也添加
        */

        //boolean containsAll(Collection<?> c)
        /*  boolean b = c.containsAll (c1);//判断是否包含第二个集合，全部包含才返回true,不改变第一个集合。
        */
      
        //boolean removeAll(Collection<?> c)
        // boolean b = c.removeAll (c1);//去除第一个集合里面包含第二个集合有的东西。
        
        
        //boolean retainAll(Collection<?> c)
        boolean b = c.retainAll (c1);//返回两个集合里面共有的。
        System.out.println (b);
        show(c);show(c1);
    }
    public static void show(Collection c){
        System.out.println ("---------------------");
        for (Object o:
             c) {
            System.out.println (o);
        }
    }
}
