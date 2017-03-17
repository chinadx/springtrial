package cn.goodman.codility;

/**
 * Created by china on 2017/3/14.
 */
public class PacerHealth {
    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; (p < 1 + l && p<=l/2); ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        /**
         * X and Y split the array into three pieces,
         * asigned them to A,B,C
         * iterate from left to right, we got X->A
         * and from right to left, we got Y->C..
         * two loops makes O(N)
         */
        int len = A.length;
        int[] as = new int[len];
        int sum = 0;
        for(int s : A) {
            sum += s;
        }

        /**
         * p to store the same sum in a and c
         */
        int[][] p = new int[sum][2];
        sum = 0;
        //from left to right
        for (int x = 0; x < len; x++) {
            sum += A[x];
            as[x] = sum;
            p[sum-1][0] = x;
        }

        int[] cs = new int[len];
        sum = 0;
        for (int y = len; y > 0; y--) {
            sum += A[y - 1];
            cs[y-1] = sum;
            p[sum-1][1] = y-1;
        }

        /**
         * if there is some SUM-NUMBER appears both in A and C
         * check if there is the same value of B
         */
        for(int i=0; i<sum; i++) {
            if((p[i][0] < p[i][1]) && (as[p[i][0]] == cs[p[i][1]])) {
                int b = sum - as[p[i][0]+1] - cs[p[i][1]-1];
                if(b == as[p[i][0]]) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        for(int j=1;j>0;j--) {
            System.out.println(j);
        }
    }
}
