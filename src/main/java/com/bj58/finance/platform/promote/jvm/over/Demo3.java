package com.bj58.finance.platform.promote.jvm.over;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {

        int counter = 0;
        List<Object> list = new ArrayList<>();

        while(true){
            list.add(new Object());
            System.out.println("当前创建了" + (counter++) + "个对象");
        }

    }
}
