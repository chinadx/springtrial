package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class OddNumOfArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = 1000000;
        int[] b = new int[N];
        for(int x : A) {
            b[x] = b[x] + 1;
        }
        for(int i=0; i<N; i++) {
            if(b[i] %2 == 1) {
                return i;
            }
        }
        return 0;
    }
}
