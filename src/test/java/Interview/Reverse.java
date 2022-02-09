package Interview;

public class Reverse {
    public static void main(String[] args) {


//		Write a return method that can reverse  String
//
//				Ex: Reverse("ABCD"); ==> DCBA
        System.out.println(StrReverse("ABCD"));
//		System.out.println(Reverse("ABCD"));
    }
    //solution 1
    public static String StrReverse(String str) {

        String reverse="";

        for(int i=str.length()-1; i >= 0; i--)

            reverse += str.toCharArray()[i];



        return  reverse;

    }
    //solution 2
//	public  static String  Reverse(String str) {
//
//		return new StringBuffer(str).reverse().toString());
}
