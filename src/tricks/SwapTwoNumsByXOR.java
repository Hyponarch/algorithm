package tricks;

public class SwapTwoNumsByXOR {
    //用异或实现无中间变量交换2个数
    public static void main(String[] args) {
        int a = 123;
        int b = 430;
        //连续3次“相同”的异或运算，实现交换
        a = a ^ b;  // a1 = a0 ^ b0;
        b = a ^ b;  // b1 = a1 ^ b0 = a0 ^ b0 ^ b0 = a0
        a = a ^ b;  // a2 = a1 ^ b1 = a0 ^ b0 ^ a0 = b0
    }
}

