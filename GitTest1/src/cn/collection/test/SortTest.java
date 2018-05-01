package cn.collection.test;

public class SortTest {
    public static void main(String[] args) {
        //冒泡排序
        int[] arr={11,2,9,65,56,10};
        for (int i = 0; i <arr.length -1; i++) {
            for (int j = 0; j <arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for (int i:arr ) {
            System.out.print (i+" ");
        }
    }
}
