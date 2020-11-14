package com.bj58.finance.platform.promote.geek.second;

/**
 * 有趣的事情
 **/
public class Interesting {
    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        System.out.println("开始");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
    }

    public synchronized void compare() {
        System.out.println("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                System.out.println("a:" + a + "b:" + b + ",a>b ?" + (a > b));
                //最后的a>b应该始终是false吗？
            }
        }
        System.out.println("compare done");
    }

    public static void main(String[] args) {


        Interesting interesting = new Interesting();

        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}
