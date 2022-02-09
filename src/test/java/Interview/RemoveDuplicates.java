package Interview;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
   // /	Write a return method that can remove the duplicated values from String
//
//			Ex:  removeDup("AAABBBCCC")  ==> ABC


    public static void main(String[] args) {
        System.out.println(removeDup("AAABBBCCC"));
        System.out.println(removeDup2("AAABBBCCC"));

    }
    //solution 1
    public static  String  removeDup( String  str) {

        String result = "";

        for (int i = 0; i < str.length(); i++)

            if (!result.contains("" + str.charAt(i)))

                result += "" + str.charAt(i);



        return result;

    }
    //solution 2
    public static String removeDup2(String str2) {

        str2 = new LinkedHashSet<String>(Arrays.asList(str2.split(""))).toString();

        str2 = str2.replace(", " ,  "" ).replace("[","").replace("]","");

        return  str2;

    }

}
