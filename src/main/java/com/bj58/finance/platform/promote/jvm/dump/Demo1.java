package com.bj58.finance.platform.promote.jvm.dump;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) throws Exception{

        List<Data> objectList = new ArrayList<>();
        for(int i =0; i < 10000; i++){
            objectList.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }
    static class Data{

    }
}
