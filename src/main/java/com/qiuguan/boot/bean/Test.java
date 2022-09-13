package com.qiuguan.boot.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qiuguan
 * @date 2022/09/09 19:53:40  星期五
 */
public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equalsIgnoreCase("2")) {
                list.add("4");
            }
        }

        System.out.println("list = " + list);
    }
}
