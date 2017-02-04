package cn.goodman;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.*;


/**
 * Created by Shaun on 2017/2/4.
 */
public class FutureRun implements Callable<String>{
    private static Log logger = LogFactory.getLog(FutureRun.class);

    @Override
    public String call() throws Exception {
        return needWait10s();
    }

    /**
     * 等待10秒
     */
    public String needWait10s() {
        logger.info("goes to 10s...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("goes out 10s...");
        return "OK";
    }

    /**
     * 等待20秒
     */
    public String needWait20s() {
        logger.info("goes to 20s...");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("goes out 20s...");
        return "OK";
    }

    public static void main(String args[]) {
        FutureRun obj = new FutureRun();
        logger.info("++++++begin...");

        /**
         * 使用串行调用
         */
//        obj.needWait10s();
//        obj.needWait20s();

        /**
         * 使用并发调用
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(obj);
        obj.needWait20s();
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        logger.info("++++++end...");
    }

}
