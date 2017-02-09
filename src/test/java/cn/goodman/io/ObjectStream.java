package cn.goodman.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;

/**
 * Created by Shaun on 2017/2/9.
 */
public class ObjectStream {
    private static Log log = LogFactory.getLog(ObjectStream.class);
    public static void main (String args[]) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:\\temp\\student.txt"));
            objectOutputStream.writeObject(new Student("刘备", 45));
            objectOutputStream.writeObject(new Student("关羽", 42));
            objectOutputStream.writeObject(new Student("张飞", 37));
            objectOutputStream.writeObject(new Student("赵云", 25));

            objectInputStream = new ObjectInputStream(new FileInputStream("F:\\temp\\student.txt"));
            for (int i = 0; i < 3; i++) {
                log.info(objectInputStream.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Student implements Serializable {
        private String name;
        private int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {

            return ("Student name = " + name + ", age = " + age);
        }
    }
}
