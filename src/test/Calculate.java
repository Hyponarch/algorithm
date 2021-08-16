package test;

public class git Calculate {
    static int count;
    public static void main(String[] args) {
        count = 0;
        int times = 6;
        int range = 4;
        int target = 18;
        //初始爆伤档位分别为1~4时的概率
        for(int i = 0; i < 4; i++){
            count = 0;
            dfs(times - 1, range, target - i);
            //强化大于等于10个额外档位的概率
            double p2 = count / Math.pow(range, times - 1);
            //强化全部出爆伤的概率
            double p3 = 1 / Math.pow(range, times - 1);
            double p1 = p2 * p3;
            System.out.println("初始爆伤档位为"+(i+1)+"时，最终爆伤超过40%的概率为"+String.format("%.10f", p1 * 100)+"%");
        }
        count = 0;
        dfs(times, range, target);
        //初始爆伤档位未知时的期望概率
        double p = count / Math.pow(range, times) / Math.pow(range, times - 1);
        System.out.println("初始爆伤档位未知时的期望概率" + String.format("%.3f", p * 100)+"%");
    }
    /**
     * dfs求满足times次取值范围为0~range=1的重复试验，结果之和大于等于target的结果的数量
     * @param times 重复试验的次数
     * @param range 取值范围0~range-1
     * @param target    目标值
     */
    static void dfs(int times, int range, int target){
        if(times == 0){
            if(target <= 0){
                count++;
            }
            return;
        }
        //如果即便按最大取值，都无法达到target，则不可能满足要求
        if(times * range < target){
            return;
        }
        //从大往小进行深度优先遍历，找到满足要求的序列数量
        for(int i = range - 1; i >= 0; i--){
            dfs(times - 1, range, target - i);
        }
    }
}
