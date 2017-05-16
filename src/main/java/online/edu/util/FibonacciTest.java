package online.edu.util;

/**
 * 斐波那契数列测试
 */
public class FibonacciTest {
    public static void main(String[] args) {
        var();
        arr();
        System.out.println("\n斐波那契数列前20项为：");
        for (int j = 1; j <= 20; j++) {
            System.out.print(getFibo(j) + "\t");
            if (j % 5 == 0)
                System.out.println();
        }
    }
    //定义三个变量方法
    public static void var(){
        int a=1, b=1, c=0;
        System.out.println("斐波那契数列前20项为：");
        System.out.print(a + "\t" + b + "\t");
        for (int i = 1; i <= 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
            if ((i + 2) % 5 == 0)
                System.out.println();
        }
    }
    //定义数组方法
    public static void arr(){
        int arr[] = new int[20];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2]; }
            System.out.println("斐波那契数列的前20项如下所示：");
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0)
                System.out.println();
                System.out.print(arr[i]+"\t");
        }
    }
    //递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return getFibo(i - 1) + getFibo(i - 2);
    }

}




