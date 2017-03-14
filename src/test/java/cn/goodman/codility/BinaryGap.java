package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        int max = 0;
        int z = 0;
        while(N > 1) {
            if(N % 2 != 0) {
                z = 0;
            } else {
                z++;
            }
            if(z > max) {
                max = z;
            }
            N = N/2;
        }
        return max;
    }
}
