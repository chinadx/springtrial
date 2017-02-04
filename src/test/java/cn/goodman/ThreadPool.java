package cn.goodman;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shaun on 2017/1/22.
 */
public class ThreadPool {
    public static void main(String args[]) {
        ThreadPool obj = new ThreadPool();
        obj.pool(10000000);
    }
    public void pool(int count) {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<Integer>();

        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(count));
        final Random random = new Random();
        for(int i = 0; i < count; i++) {
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }

        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(list.size());
    }
}
