package cn.goodman.threads;

/**
 * Created by Shaun on 2017/4/13.
 * 测试直接结束JVM的情况下finally块能否执行。结果是不执行。
 */
public class FinallyTest {
    public static void main (String[] args) {
        try {
            System.out.println("aaaaaaaaaaaa");
            Thread.sleep(10000L);
            System.out.println("bbbbbbbbb");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("ffffffffffffffffff");
        }
    }
}
