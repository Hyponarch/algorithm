package LeetCode;
import java.util.*;
public class Problem_765 {
    public static void main(String[] args) {
        Solution s = new Problem_765().new Solution();
        s.minSwapsCouples(new int[]{0,2,1,3});
    }
    class Solution {
        public int minSwapsCouples(int[] row) {
            //若n组情侣恰好组成一个闭环（该2n个人可以凑成n对），则要交换n-1次
            //用set存储，记录当前的组数和凑成的对数？
            //第一组先加入，然后遍历一遍，如果另一半不在set里，则加入。
            //如果一轮下来，没有增加元素，则找到了一个闭环，依据当前的size，为结果增加size-1
            //row用来求邻居，依据下标
            //numIdx用来求配偶，根据数值
            Map<Integer, Integer> numIdx = new HashMap<>();
            int ans = 0;
            for(int i = 0; i < row.length; i++){
                numIdx.put(row[i], i);
            }
            for(int i = 0; i<row.length; i += 2){
                //2个数是一起处理的
                if(numIdx.containsKey(row[i])){
                    Map<Integer, Integer> closure = new HashMap<>();
                    closure.put(row[i], i);
                    closure.put(row[i+1], i+1);
                    numIdx.remove(row[i]);
                    numIdx.remove(row[i+1]);

                    //重复遍历closure，直到没有增加
                    while(true){
                        //记录是否修改了closure
                        boolean isClosure = true;
                        //copy一份，避免遍历时修改异常
                        Map<Integer, Integer> closureCopy = new HashMap<>(closure);
                        //遍历copy，修改原件
                        for(Integer key : closureCopy.keySet()){
                            int another = key % 2 == 0 ? key + 1 : key - 1;
                            //closure内还有没配对成功的元素
                            if(!closure.containsKey(another)){
                                isClosure = false;
                                int anotherIdx = numIdx.get(another);
                                closure.put(another, anotherIdx);
                                numIdx.remove(another);
                                //跟another一组的元素
                                int anotherNeighborIdx = anotherIdx % 2 == 0 ? anotherIdx + 1 : anotherIdx - 1;
                                closure.put(row[anotherNeighborIdx], anotherNeighborIdx);
                                numIdx.remove(row[anotherNeighborIdx]);
                            }
                        }
                        //一轮循环结束未修改
                        if(isClosure){
                            ans += closure.size()/2 - 1;
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
