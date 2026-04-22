package Week14;

import java.util.*;

public class ThreadingLab {

    static class SumRunnable implements Runnable {
        private long sum = 0;

        public void run() {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
        }

        public long getSum() {
            return sum;
        }
    }

    static class SumThread extends Thread {
        private long sum = 0;

        public void run() {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
        }

        public long getSum() {
            return sum;
        }
    }

    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public void incrementUnsafe() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class CounterThread extends Thread {
        private Counter counter;
        private boolean safe;

        public CounterThread(Counter counter, boolean safe) {
            this.counter = counter;
            this.safe = safe;
        }

        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (safe)
                    counter.increment();
                else
                    counter.incrementUnsafe();
            }
        }
    }

    public static long sumSquaresSingle(int[] arr) {
        long sum = 0;
        for (int x : arr) {
            sum += (long) x * x;
        }
        return sum;
    }

    static class SquareSumThread extends Thread {
        private int[] arr;
        private int start, end;
        private long sum = 0;

        public SquareSumThread(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                sum += (long) arr[i] * arr[i];
            }
        }

        public long getSum() {
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {

        SumRunnable r = new SumRunnable();
        Thread t1 = new Thread(r);

        t1.start();
        t1.join(); 

        System.out.println("Runnable Sum: " + r.getSum());

        SumThread t2 = new SumThread();

        t2.start();
        t2.join();

        System.out.println("Thread Sum: " + t2.getSum());

        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new CounterThread(counter, true));
        }

        threads.forEach(Thread::start);
        for (Thread t : threads) t.join();

        System.out.println("Synchronized Counter: " + counter.getCount());

        Counter counterUnsafe = new Counter();
        threads.clear();

        for (int i = 0; i < 10; i++) {
            threads.add(new CounterThread(counterUnsafe, false));
        }

        threads.forEach(Thread::start);
        for (Thread t : threads) t.join();

        System.out.println("Unsynchronized Counter: " + counterUnsafe.getCount());

        // ---- Threading performance test ----
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 100;

System.out.println("n,Single(ms),Multi(ms)");

while (n <= 100_000_000) {

    int[] arr = new Random().ints(n, 1, 101).toArray();

    // ---- Single thread timing ----
    long startTime = System.nanoTime();
    long singleSum = sumSquaresSingle(arr);
    long endTime = System.nanoTime();

    long singleTime = (endTime - startTime) / 1_000_000; // convert to ms

    // ---- Multi-thread timing ----
    SquareSumThread s1 = new SquareSumThread(arr, 0, n / 2);
    SquareSumThread s2 = new SquareSumThread(arr, n / 2, n);

    startTime = System.nanoTime();

    s1.start();
    s2.start();

    s1.join();
    s2.join();

    long multiSum = s1.getSum() + s2.getSum();

    endTime = System.nanoTime();
    long multiTime = (endTime - startTime) / 1_000_000; // convert to ms

    // Print CSV format for plotting
    System.out.println(n + "," + singleTime + "," + multiTime);

    n *= 10; // increase by factor of 10
    }
}
}

//For small input sizes, the single-threaded approach is faster because the overhead of thread creation, 
//scheduling, and synchronization outweighs the benefits of parallelism. As the input size increases, 
//the computational workload becomes dominant, allowing multiple threads to execute in parallel across CPU cores,
//thereby reducing execution time. Hence, multithreading becomes more efficient for large values of n.

