package com.pentacle.jsoup;

import java.util.Arrays;

public class demoXishu {
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
//        System.out.println("输出原始数组：");
//        for (int[] intAry : array) {
//            for (int ints : intAry) {
//                System.out.print(ints + "\t");
//            }
//            System.out.println();
//        }
        System.out.println("++++++++++++++++++++++++++++++");
        //转换为稀疏数组保存
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效的个数：" + sum);
        //创建一个稀疏数组的数组
        int[][] array2 = new int[sum + 1][3];
        array2[0][0] = 11; //存了多少行
        array2[0][1] = 11; //存了多少列
        array2[0][2] = sum; //存的个数
        //遍历二维数组，将非零的值，存放到稀疏数组中
        int count = 0; //定义总共的数量
        for (int i = 0; i < array.length; i++) {//未压缩之前的棋盘
            for (int j = 0; j < array[i].length; j++) { //遍历有效个数的值
                if (array[i][j] != 0) {
                    count++; //计数用
                    array2[count][0] = i; //横坐标
                    array2[count][1] = j; //纵坐标
                    array2[count][2] = array[i][j]; //值
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i][0] + "\t"
                    + array2[i][1] + "\t"
                    + array2[i][2] + "\t");
        }
    }
}
