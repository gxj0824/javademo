package com.tqym;


import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Application
 * @Description 主方法
 * @Author 洛城天使
 * @Date: 2021/9/21 11:28
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        int length = 10;
        int[] arr = getArr(length);

        //测试稀疏数组与二维数组的转换
        //TestSparseArray();

        //测试冒泡排序
        //System.out.println(Arrays.toString(SortAlgorithm.bubbleSort(arr)));

        //测试杨辉三角
        //DataStructure.generate(5).forEach(System.out::println);
    }

    private static int[] getArr(int length) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(11);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static int[][] getArr(int r, int c) {
        Random random = new Random();
        int[][] arr = new int[random.nextInt(r)][random.nextInt(c)];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = random.nextInt(11);
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
