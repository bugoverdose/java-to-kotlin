package com.example.javaspring.util;

import java.util.ArrayList;
import java.util.Arrays;

public class GetColor {

    private static final GetColor instance = new GetColor();

    public static String randomColor(ArrayList<String> list){
        if (list.isEmpty())
            list = new ArrayList<String>(Arrays.asList("Red", "Green", "Blue", "Black"));
        return list.get((int) Math.floor(Math.random() * list.size()));
    }
}
