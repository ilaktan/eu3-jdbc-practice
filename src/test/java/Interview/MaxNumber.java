package Interview;

import java.util.Arrays;

public class MaxNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Write a method that can find the maximum
        //number from an int Array

        int []maxNumber=new int[] {2,3,4,5,6,-10};


        System.out.println(maxValue(maxNumber));
        System.out.println(maxValue2(maxNumber));

    }
    public static int maxValue(int[] num) {

        int max=Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {

            if(num[i]>max) {

                max=num[i];


            }
        }
        return max;

    }
    public static int maxValue2(int[] num) {

        Arrays.sort(num);
        return num[num.length-1];
    }
}
