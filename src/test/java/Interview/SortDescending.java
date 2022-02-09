package Interview;

import java.util.ArrayList;
import java.util.Arrays;

public class SortDescending {
    public static void main(String[] args) {

//	Array -- Sort Descending
//	Write a return method that can sort an int array
//	in descending order without using the sort method
//	of the Arrays class
//
//	Ex:  int[] arr = {10,20,7, 8, 90};
//
//	                 arr = Sort(arr);  ==>  {90, 20, 10, 8, 7};


        //Solution 1:
        int[]myL= {3, 9, 2, 7};
        Sort(myL);
        System.out.println(Arrays.toString(Sort(myL)));

        //Solution 2:
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(99);
        nums.add(656);
        nums.add(100);
        System.out.println(findMax(nums));




        //Solution 3:
        int[]myList= {4, 6, 2, 10};
        SortingArrayDesc(myList);


    }
    public static int[] Sort(int[] a) {

        ArrayList<Integer> list=new ArrayList<Integer>();

        for(int each: a)

            list.add(each);



        for(int i=0; i < a.length; i++) {

            a[i] = findMax(list);

            list.remove(Integer.valueOf(a[i]));

        }

        return a;

    }

//Solution 2:

    public static int findMax(ArrayList<Integer> a) {

        int max=Integer.MIN_VALUE;

        for(int each: a)

            max = Math.max(max, each);

        return max;

    }
    //Solution 3:
    public static void SortingArrayDesc(int[] arr) {

        ArrayList<Integer> list = new ArrayList();

        for(int each: arr) {

            list.add(each);

        }

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size(); j++) {

                if (list.get(i) > list.get(j)) {

                    Integer temp = list.get(i);

                    list.set(i, list.get(j));

                    list.set(j, temp);

                }

            }

        }

        for(int i=0; i < list.size(); i++) {

            arr[i] = list.get(i);

        }
        System.out.println(Arrays.toString(arr));
    }
}
