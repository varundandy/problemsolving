package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TestExecutor {


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        final List<CompletableFuture<Integer>> futureList = new ArrayList<>();
        MyThread thread1 = new MyThread(1, 50);
        MyThread thread2 = new MyThread(2, 2);
        MyThread thread3 = new MyThread(3, 30);
        List<MyThread> list = new ArrayList<>();
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);

        final Executor executor = Executors.newSingleThreadExecutor();
        for (MyThread thread : list) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> thread.call());
            //futureList.add(future);
            System.out.println(future.get());
        }


    }


    public static class MyThread implements Callable {
        Integer value = null;
        long waitTime = 0;

        public MyThread(Integer value, int waitTime) {
            this.value = value;
            this.waitTime = waitTime;
        }

        @Override
        public Integer call()  {
            System.out.println("Value: " + value);
            try {
                this.wait(waitTime);
            } catch (InterruptedException e) {
                System.out.println("Thread-Tnterrupted");
            }
            return value;
        }
    }
}
