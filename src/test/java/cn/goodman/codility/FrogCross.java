package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class FrogCross {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int[] m = new int[X];
        int cnt = 0;
        for(int i = 0; i < len; i ++) {
            int tmp = A[i];
            if(m[tmp-1] == 0) {
                cnt++;
            }
            m[tmp-1] = 1;
            if(cnt == X) {
                return i;
            }
        }
        return len;
    }
}
