package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread("+");
        t1.start();
        MyThread t2 = new MyThread("-");
        t2.start();
        Thread.sleep(3000);
        t1.flag = false;
        t1.join(); // дождаться завершения 1 потока
        test("1 stopped!");

    }

    private static Object key = new Object();
    public static void test(String m) {
        try {
            synchronized (key) {
                System.out.print("[");
                Thread.sleep(1000); // 1 сек
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
             //   key.notify(); // возобн. поток который в режиме wait()
             //   key.wait(); // переводит поток в режим ожидания до команды notify()

            }
        } catch (Exception e) {

        }
    }
}
