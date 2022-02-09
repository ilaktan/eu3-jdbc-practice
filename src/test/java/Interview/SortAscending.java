package Interview;

import java.util.ArrayList;
import java.util.Arrays;

public class SortAscending {
    public static void main(String[] args) {

//
//		Array -- Sort Ascending
//		Write a return method that can sort an
//				int array in Ascending order without
//				using the sort method of the Arrays
//				class
//		Ex:
//
//            int[] arr = {10, 9, 8, 7};
//
//             arr = Sort(arr);         ==>{ 7, 8, 9, 10};


        //Solution 1:
        int[]myL= {3, 9, 2, 7};
        Sort(myL);
        System.out.println(Arrays.toString(Sort(myL)));

        //Solution 2:
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(99);
        nums.add(656);
        nums.add(100);
        System.out.println(findMin(nums));




        //Solution 3:
        int[]myList= {4, 6, 2, 10};
        SortingArrayAsc(myList);






    }
    //solution 1
    public static int[] Sort(int[] a) {

        ArrayList<Integer> list=new ArrayList<Integer>();

        for(int each: a)

            list.add(each);



        for(int i=0; i < a.length; i++) {

            a[i] = findMin(list);

            list.remove(Integer.valueOf(a[i]));

        }

        return a;

    }

    //solution 2
    public static int findMin(ArrayList<Integer> a) {

        int min =Integer.MAX_VALUE;

        for(int each: a)

            min = Math.min(min, each);

        return min;

    }
    //	solution 3
    public static void SortingArrayAsc(int[] arr) {

        ArrayList<Integer> list = new ArrayList();

        for(int each: arr) {

            list.add(each);

        }

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size(); j++) {

                if (list.get(i) < list.get(j)) {

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
