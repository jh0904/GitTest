import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;

public class CollectionTest {
    /*
    * Collection的功能：
    * 1:添加
    *       boolean add(E e)
    *       boolean addAll(Collection<? extends E> c) 将指定 collection 中的所有元素都添加到此 collection中（可选操作）。
    * 2.删除
    *       void clear()  移除此 collection 中的所有元素（可选操作）。
    *       boolean remove(Object o) 删除一个指定的
    *       boolean removeAll(Collection<?> c) 删除指定 collection 中的所有元素
    * 3.判断
    *       boolean contains(Object o) 判断集合是否包含o元素
    *       boolean containsAll(Collection<?> c) 判断集合是否包含指定 collection 中的所有元素
    *       boolean isEmpty() 判断集合是否为空
    * 4.获取
    *       Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器
    * 5.长度
    *       int size() 返回此 collection 中的元素数
    * 6.交集
    *       boolean retainAll(Collection<?> c)  移除此Collection中包含在指定的Collection中所有的元素，
    *       集合A和集合B做交集，最终的结果保存在集合A，返回值表示的是A是否发生变化。
    *  JAVA8新特性：
    *
    * */
    public static void main(String[] args) {

        Collection c = new ArrayList ();
        c.add ("hello");
        c.add (1);
        c.add ("world");
        System.out.println ("c.size()----->"+c.size ());
        System.out.println ("包含----->"+c.contains (1));
        System.out.println ("isEmpty------>"+c.isEmpty ());
        System.out.println ("-----------删除前---------");
        for( Object o: c){
            System.out.println (o);
        }
        c.remove(1);
        System.out.println ("-----------删除后---------");
        for( Object o: c){
            System.out.println (o);
        }
        /*  Iterator的三种方法：hasNext() next() remove()
            它是在ArrayList以内部类的方式实现的！并且，从源码可知：Iterator实际上就是在遍历集合
            所以说：我们遍历集合(Collection)的元素都可以使用Iterator，至于它的具体实现是以内部类的方式实现的！
        */
        System.out.println ("----------第一种Iterator遍历方法--------------");
        Iterator it = c.iterator (); //第一种Iterator遍历方法
        while (it.hasNext ()){
            Object next = it.next ();
            System.out.println (next);
        }
        System.out.println ("----------第二种Iterator遍历方法--------------");
        for ( Iterator i=c.iterator();i.hasNext ();){
            Object n = i.next ();
            System.out.println (n);
        }
    }
}
