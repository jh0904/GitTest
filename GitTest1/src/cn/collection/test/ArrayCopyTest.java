package cn.collection.test;

public class ArrayCopyTest {
    //System.arraycopy()改变的是第二个数组，就是把第一个数组从srcPos的位置开始复制length长度，到第二个数组的destPos位置。
    /*像System.arraycopy(elementData, index, elementData, index + 1,size - index);
    * 其实就是把第一个数组长度先扩容，然后在index位置，把后面的数组再往后移动一个位置。
    * 例如：{1,2,3,4,5,} 变成{1,2,3,3,4,5}  */
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4};
        int[] arr1={5,6,7,8,9,};
        System.arraycopy (arr,1,arr1,2,2);
        show (arr);
        show (arr1);
    }
    public static void show(int[] arr){
        for (int i:
             arr) {
            System.out.print (i);
        }
        System.out.println ("----------------------");
    }
}
