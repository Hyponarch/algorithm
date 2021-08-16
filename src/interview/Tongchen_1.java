package interview;

public class Tongchen_1 {

    public class Solution {
        /**
         * 计算模型参数w1、w2和b的梯度
         * @param data double浮点型二维数组 训练样本，每行表示一个样本，每行第一个元素为标签y，第二个元素为x1，第三个元素为x2
         * @param w1_current double浮点型 w1的当前值
         * @param w2_current double浮点型 w2的当前值
         * @param b_current double浮点型 b的当前值
         * @return double浮点型一维数组
         */
        public double[] calcGradient (double[][] data, double w1_current, double w2_current, double b_current) {
            // write code here
            //学习率？
            //一轮梯度下降
            double[] para_new = gradientDecent(data, w1_current, w2_current, b_current);
            return calculateGradient(data, para_new[0], para_new[1], para_new[2]);
        }
        double mse(double[][] data, double w1_current, double w2_current, double b_current){
            double mse = 0;
            for(double[] d : data){
                double y = d[1] * w1_current + d[2] * w2_current + b_current;
                mse += (y - d[0]) * (y - d[0]);
            }
            return mse / data.length;
        }
        double[] gradientDecent(double[][] data, double w1_current, double w2_current, double b_current){
            //导数
            double n = data.length;
            double b_gradient = 0;
            double w1_gradient = 0;
            double w2_gradient = 0;
            for(double[] d : data){
                b_gradient += 2 * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
                w1_gradient += 2 * d[1] * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
                w2_gradient += 2  * d[2] * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
            }
            double b_new = b_current - b_gradient / n;
            double w1_new = w1_current - w1_gradient / n;
            double w2_new = w2_current - w2_gradient / n;
            return new double[]{w1_new, w2_new, b_new};
        }
        double[] calculateGradient(double[][] data, double w1_current, double w2_current, double b_current){
            double n = data.length;
            double b_gradient = 0;
            double w1_gradient = 0;
            double w2_gradient = 0;
            for(double[] d : data){
                b_gradient += 2 * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
                w1_gradient += 2 * d[1] * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
                w2_gradient += 2  * d[2] * (w1_current * d[1] + w2_current * d[2] + b_current - d[0]);
            }
            return new double[]{w1_gradient, w2_gradient, b_gradient};
        }
    }
}
