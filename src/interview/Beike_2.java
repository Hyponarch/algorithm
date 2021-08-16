package interview;

import java.util.*;

/**
3 2
a 1 10
p 1 6
b 100 1
a 10
b 1
 */
public class Beike_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //商品种数
        int m = sc.nextInt();   //订单数量
        sc.nextLine();
        Map<String, int[]> goods = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            goods.put(input[0], new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }
        int ans = 0;
        boolean canApply = true;
        for(int i = 0; i < m; i++){
            String[] order = sc.nextLine().split(" ");
            String name = order[0];
            int num = Integer.parseInt(order[1]);
            int[] good = goods.get(name);
            int store = good[1];
            int price = good[0];
            if(store >= num){
                ans += price * num;
                goods.put(name, new int[]{price, store - num});
            }else {
                System.out.println("-" + (i+1));
                canApply = false;
                break;
            }
        }
        if(canApply){
            System.out.println(ans);
        }

    }
}
