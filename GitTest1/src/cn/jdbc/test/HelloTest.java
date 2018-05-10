package cn.jdbc.test;

public class HelloTest {
    /*主要用位运算实现加减乘除*/
    public static void main(String[] args) {
        int add = add (5, 6);
        System.out.println ((8 & 3));
    }

    public static int add(int a, int b) {
        if (b == 0) //递归结束条件：如果右加数为0，即不再有进位了，则结束。
            return a;
        int s = a ^ b;
        int c = (a & b) << 1; //进位左移1位，达到进位的目的。
        return add (s, c); //再把'和'和'进位'相加。递归实现。
    }

    public static float subtract(int a, int b) {

        return 0;
    }

    public static float multiply(int a, int b) {

        return 0;
    }

    public static float divide(int a, int b) {

        return 0;
    }

}
