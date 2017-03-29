package cn.goodman.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Shaun on 2017/3/29.
 */
public class TaskCollection implements Runnable{
    public static BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
    public int index;

    public TaskCollection(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("第" + this.index + "个线程开始干活了...");
        try {
            Thread.sleep((long)(Math.random() * 10000));
            queue.put(this.index);
            System.out.println("第" + this.index + "个线程干完了...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            executorService.submit(new TaskCollection(i));
        }

        int count = 0;
        while(true) {
            if(count == 10) {
                break;
            }
            if(queue.isEmpty()) {
                continue;
            }
            try {
                int value = queue.take();
                System.out.println("====取出了第" + value + "个数据！");
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
