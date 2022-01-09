package com.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamProblem {

    public static void main(String args[])
    {
        List<String> str = new ArrayList<>();
        str.add("aatma");
        str.add("baba");
        str.add("confluence");
        str.add("drama");
        str.add("elephant");
        str.add("fly");
        str = str.parallelStream().map( l -> String.valueOf(l.charAt(l.length() - 1))).collect(Collectors.toList());
        System.out.println(Arrays.toString(str.toArray()));
    }
}
