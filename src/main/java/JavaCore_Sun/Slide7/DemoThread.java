// 📁 Slide7 - Tổng hợp ví dụ về Thread & Đa luồng trong Java
package JavaCore_Sun.Slide7;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoThread {
    public static void main(String[] args) throws InterruptedException {

        //  Tạo thread bằng kế thừa Thread
        Thread t1 = new ThreadA();
        t1.start();

        //  Tạo thread bằng implements Runnable
        Thread t2 = new Thread(new TaskB());
        t2.start();

        //  Tạo thread bằng lambda expression
        Thread t3 = new Thread(() -> System.out.println("[Lambda] Luồng đang chạy: " + Thread.currentThread().getName()));
        t3.start();

        //  Race condition - không đồng bộ hóa
        Counter counter1 = new Counter();
        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter1.increase();
        });
        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter1.increase();
        });
        c1.start(); c2.start();
        c1.join(); c2.join();
        System.out.println("[Không đồng bộ] Count = " + counter1.count);

        //  Synchronized method để đảm bảo an toàn
        CounterSafe counter2 = new CounterSafe();
        Thread c3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter2.increase();
        });
        Thread c4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter2.increase();
        });
        c3.start(); c4.start();
        c3.join(); c4.join();
        System.out.println("[Có synchronized] Count = " + counter2.count);

        //  Dùng AtomicInteger (thread-safe)
        AtomicInteger atomic = new AtomicInteger();
        Thread c5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) atomic.incrementAndGet();
        });
        Thread c6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) atomic.incrementAndGet();
        });
        c5.start(); c6.start();
        c5.join(); c6.join();
        System.out.println("[AtomicInteger] Count = " + atomic.get());

        //  Dùng ExecutorService (thread pool)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("[Executor] Tác vụ 1"));
        executor.submit(() -> System.out.println("[Executor] Tác vụ 2"));
        executor.shutdown();
    }
}

//  Lớp kế thừa Thread
class ThreadA extends Thread {
    public void run() {
        System.out.println("[ThreadA] Đang chạy: " + Thread.currentThread().getName());
    }
}

//  Lớp implements Runnable
class TaskB implements Runnable {
    public void run() {
        System.out.println("[Runnable] Đang chạy trong: " + Thread.currentThread().getName());
    }
}

//  Counter không đồng bộ
class Counter {
    int count = 0;
    public void increase() {
        count++;
    }
}

//  Counter đồng bộ hóa bằng synchronized
class CounterSafe {
    int count = 0;
    public synchronized void increase() {
        count++;
    }
}
