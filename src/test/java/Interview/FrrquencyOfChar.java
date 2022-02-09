package Interview;

public class FrrquencyOfChar {
    public static void main(String[] args) {


//		* String -- Frequency of Characters Write a return method that can find the
//				 * frequency of characters
//				 *
//				 * -->: FrequencyOfChars("AAABBCDD") ==> A3B2C1D2


        System.out.println(FrrquencyOfChar("AAABBCDD"));

    }

    public static String FrrquencyOfChar(String str) {

        String unique="";

        for (int i = 0; i < str.length(); i++) {



            if(!unique.contains(str.charAt(i)+"")) {

                unique+=str.charAt(i);


            }


        }

        String result="";

        for (int i = 0; i < unique.length(); i++) {

            int count=0;

            for (int j = 0; j < str.length(); j++) {

                if(str.charAt(j)==unique.charAt(i)) {

                    count++;


                }

            }

            result=result+unique.charAt(i)+count;
        }


        return result;

    }

}
