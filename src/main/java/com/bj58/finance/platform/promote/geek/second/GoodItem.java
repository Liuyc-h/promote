package com.bj58.finance.platform.promote.geek.second;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

@Data
@RequiredArgsConstructor
public class GoodItem {

    final String name; //商品名
    int remaining = 1000; //库存剩余
    // @ToString.Exclude //ToString不包含这个字段
    ReentrantLock lock = new ReentrantLock();
}
