package com.winterbe.java8.samples.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class SellTickets {
    AtomicInteger tickets = new AtomicInteger(100);

    class Seller implements Runnable {
        @Override
        public void run() {
            while (tickets.get() > 0) {
                int tmp = tickets.get();
                if (tickets.compareAndSet(tmp, tmp - 1)) {
                    System.out.println(Thread.currentThread().getName() + "  " + tmp);
                }
            }
        }

    }

    public static void main(String[] args) {
        SellTickets st = new SellTickets();
        new Thread(st.new Seller(), "SellerA").start();
        new Thread(st.new Seller(), "SellerB").start();
    }
}