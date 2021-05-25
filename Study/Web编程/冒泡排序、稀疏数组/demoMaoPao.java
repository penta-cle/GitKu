package com.pentacle.jsoup;

import java.util.Arrays;

public class demoMaoPao {
    public static void main(String[] args) {
        int[] array = {1,2,4,5,7,8,3,10,9};
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j+1] > array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
