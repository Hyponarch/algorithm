package grammer;

import java.util.Arrays;
import java.util.Scanner;

public class Base {
    static int global = 1;
    int object = 2;
    static void helloWorld(){
        System.out.println("hello world static");
    }

    void helloWorld1(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = -1;
        while (true){
            System.out.println("请输入一个int");
            String inputLine = sc.nextLine();
            try {
                input = Integer.parseInt(inputLine);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字格式错误，请重新输入");
            }
        }




        System.out.println(input);

        Base.helloWorld();
        Base base = new Base();
        base.helloWorld1();
        base.helloWorld();
//        int a = Base.global;
//        int b = base.object;


        //常见数据类型
        //int整型[-2^31, 2^31-1]
        int i = 1;
        //long长整型[-2^63, 2^63-1]
        long l = 1L;
        l = 1;
        //float单精度浮点数
        float f = 0.1f;
        //double双精度浮点数
        double d = 0.1d;
        //char字符
        char c = 'a';
        c = '1';
        //String字符串
        String s = "hello world";
        //boolean布尔,java中不能使用整型来表示布尔值
        boolean b = true;

        int[] nums = new int[2];
        nums[0] = 0;
        nums[1] = 10;
        int[] nums1 = new int[]{3, 2, 4};
        Arrays.sort(nums1);

        //整型计算
        //整型计算是精确的，所以整型结果可以用 == 来比较
        int num1 = 3;
        int num2 = 2;
        System.out.println("2 * 3 = " + 2 * 3);
        System.out.println(2 * 3 == 6);

        //整数除法采用的向0取整 5 / 2= 2.5 5//2 = 2
        System.out.println("5 / 2 = " + 5 / 2);
        System.out.println("-5 / 2 = " + (-5 / 2));

        //浮点数
        //浮点数的表示是近似的，所以
        double num3 = 1.0 / 10;
        double num4 = 1.0 - 1.0 / 10;
        System.out.println(num3);
        System.out.println(num4);
        System.out.println("num3和num4相等吗？" + (num3 == num4));
        System.out.println("num3 - num4 = " + (num3 - num4));
        //所以一般不能使用 == 来给浮点数判断相等
        //通常认为2个浮点数相差很小就是相等的，比如说判断0.000001
        double diff = 1e-6;

        changeNums(new int[]{1});

        int[][] arrArr = new int[2][];
        arrArr[0] = new int[]{0, 1, 2};
        arrArr[1] = new int[]{2, 3};

        }
        //单行注释
        /*

         */

    /**
     * 说明功能
     * @param arr   参数说明
     */
    static void changeNums(int[] arr){
            arr[0] = -1;
        }
        static void cannotChangeInt(int a){
            a = -1;
        }

}
