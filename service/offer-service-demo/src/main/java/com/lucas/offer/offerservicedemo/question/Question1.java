package com.lucas.offer.offerservicedemo.question;

/**
 * @author LucasLee
 * @data ${data} ${time}
 */
public class Question1 {

    /**
     * 问题描述：
     * 一个整型数组里除了一个数字以外，其他数字都出现了两次。找出这个只出现一次的数字
     * 算法思路：
     * 异或运算：任何一个数字异或它本身都等于0,
     * 如果从头到尾异或数组中的每一个数字，那些出现两次的数字全部在异或中会被抵消，
     * 最终的结果刚好是这个只出现一次的数字
     *
     * @param a
     * @return
     */
    public static int getOneBy2(int a[]) {
        int n = a.length;
        int result = 0;
        System.out.println(result);
        int i;
        for (i = 0; i < n; ++i) {
            result ^= a[i];
            System.out.println(i + ":" + result);
        }
        return result;
    }


    /**
     * 问题描述：
     * 一个整型数组里除了2个数字以外，其他数字都出现了两次。找出这个只出现一次的2个数字
     *
     * @param array
     * @return
     */
    public static void getTowBy2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }

        int indexOf1 = 0;
        while (((resultExclusiveOR & 1) == 0) && (indexOf1 <= 4 * 8)) {
            resultExclusiveOR = resultExclusiveOR >> 1;  //只有n>>1不完整，要n=n>>1
            indexOf1++;
        }

        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (((array[i] >> indexOf1) & 1) == 1) {
                number1 ^= array[i];
            } else {
                number2 ^= array[i];
            }
        }
        System.out.println(number1 + ":" + number2);
    }

    /**
     * 问题描述：
     * 一个整型数组里除了1个数字以外，其他数字都出现了三次。找出这个只出现一次的数字
     * 算法思路：
     * 先求出每一位出现1的个数
     * 每一位个数整除3
     *
     * @param input
     * @return
     */
    public static int getOneBy3(int[] input) {
        if (input == null) {
            throw new RuntimeException("参数错误");
        }
        //每一位进行相加
        int index = 0;
        int result = 0;
        while (index < 32) {
            int sum = getBitSum(input, index);
            result |= ((sum % 3) << index);
            index++;
        }
        return result;
    }

    private static int getBitSum(int[] input, int index) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result += getBit(input[i], index);
        }
        return result;
    }

    private static int getBit(int value, int index) {
        return (value & (1 << index)) >>> index;
    }

}
