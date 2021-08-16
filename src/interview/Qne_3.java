package interview;

import java.util.*;

public class Qne_3 {
    //日期相邻，且价格相同，则合并
    //日期重叠，且价格不同，则按后面的价格拆分
    //将数据转化成Map<Integer, List<int[]>>的形式，Key为价格，value为区间列表，int[] = {start, end}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Map<Integer, List<int[]>> map = new HashMap<>();
        //用日期作为key
        Map<Integer, Integer> datePrice = new HashMap<>();
        int firstDate = Integer.MAX_VALUE;
        int lastDate = 0;
        while (sc.hasNextLine()){
            String[] record = sc.nextLine().split("[-~:]");
//            System.out.println(Arrays.toString(record));
            int start = Integer.parseInt(record[0] + record[1] + record[2]);
            firstDate = Math.min(firstDate, start);
            int end = Integer.parseInt(record[3] + record[4] + record[5]);
            int price = Integer.parseInt(record[6]);

            for(int i = start; i <= end; i++){
                datePrice.put(i, price);
            }
//            int[] intv = new int[]{start, end};
//            List<int[]> list = map.getOrDefault(price, new ArrayList<int[]>());
//            //保证list有序
//            list.add(intv);
//            list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//            //合并区间
//            for(int[] interval : list){
//
//            }
//            if(!map.containsKey(price)){
//                map.put(price, new ArrayList<>(List.of(new int[]{start, end})));
//            }else
        }




    }
}
