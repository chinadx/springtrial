package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long sum = 0;
        long sumPre = 0;
        long min = 0;
        for(int m : A) {
            sum += m;
            min += Math.abs(m);
        }
        for(int n : A) {
            sumPre += n;
            long tmp = Math.abs(sumPre - (sum - sumPre));
            if(tmp < min) {
                min = tmp;
            }
        }
        return (int)min;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        TapeEquilibrium obj = new TapeEquilibrium();
        obj.solution(A);
    }
}
