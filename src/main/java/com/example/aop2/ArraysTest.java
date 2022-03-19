package com.example.aop2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysTest
{
    public static void main(String[] args){
        Integer[] arr1 = {1,2,3,4,5};
        int result = Arrays.stream(arr1).reduce (0,Integer::sum);
        System.out.println (result);

        Stream str1 = Arrays.stream(arr1);
        System.out.println(str1.count());
        System.out.println(str1.count());
    }
}
