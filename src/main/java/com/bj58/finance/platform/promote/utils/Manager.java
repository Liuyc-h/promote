package com.bj58.finance.platform.promote.utils;



public class Manager {


    static {
        if (true) { // 这里是为了保证一定抛出该异常，如果你在static块中直接抛异常，编译无法通过
            throw new NullPointerException();
        }
    }
}
