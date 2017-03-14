package cn.goodman.codility;

/**
 * Created by Shaun on 2017/3/14.
 */
public class FrogJmp {
    /**
     * A very bad solution.
     * for better time performance, we should use (Y-X)/D to calculate first.
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if(X == Y) {
            return 0;
        }
        int P = X;
        int i = 0;
        while(P < Y) {
            P = P + D;
            i++;
        }
        return i;
    }
}
