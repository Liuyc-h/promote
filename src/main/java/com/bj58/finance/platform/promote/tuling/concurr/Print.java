package com.bj58.finance.platform.promote.tuling.concurr;

import org.openjdk.jol.info.ClassLayout;

public class Print {

    public static void main(String[] args) {

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
