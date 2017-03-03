package cn.goodman.algorithm;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Shaun on 2017/3/3.
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        ProducerConsumer obj = new ProducerConsumer();
        Storage storage = new Storage();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer p1 = new Producer("张三", storage);
        Producer p2 = new Producer("李四", storage);

        Consumer c1 = new Consumer("John", storage);
        Consumer c2 = new Consumer("Michael", storage);
        Consumer c3 = new Consumer("Jackson", storage);

        service.submit(p1);
        service.submit(p2);

        service.submit(c1);
        service.submit(c2);
        service.submit(c3);
    }
    /**
     * 消费者
     */
    static class Consumer implements Runnable {
        private String name;
        private Storage storage = null;

        public Consumer(String name, Storage storage) {
            this.name = name;
            this.storage = storage;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Product product = storage.pop();
                    System.out.println("消费者[" + this.name + "]已消费" + product.toString());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 生产者
     */
    static class Producer implements Runnable {
        private String name;
        private Storage storage = null;

        public Producer(String name, Storage storage) {
            this.name = name;
            this.storage = storage;
        }

        @Override
        public void run() {
            while(true) {
                Random random = new Random();
                Product product = new Product(random.nextInt(1000));
                System.out.println("生产者[" + this.name + "]" + "已生产：" + product.toString());
                try {
                    storage.push(product);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 仓库内部类
     */
    static class Storage {
        BlockingQueue<Product> queues = new LinkedBlockingQueue<>(5);

        /**
         * 生产产品
         */
        public void push(Product product) throws InterruptedException {
            queues.put(product);
        }

        /**
         * 消费产品
         */
        public Product pop() throws InterruptedException {
            return queues.take();
        }
    }
    /**
     * 产品内部类
     */
    static class Product {
        private int id;

        public Product(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    '}';
        }
    }
}
