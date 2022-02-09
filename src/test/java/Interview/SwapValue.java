package Interview;

public class SwapValue {
    public static void main(String[] args) {


        int a=10 , b=20;


        System.out.println("before a= "+a);        //10
        System.out.println("before b= "+b);        //20
        System.out.println(".......................");

        int t=a;           	                     //a=10,b=20,t=10
        a=b;                                  //a=20,b=20,t=10
        b=t;                                  //a=20,b=10,t=10

        System.out.println("after a= "+a);        //20
        System.out.println("after b= "+b);        //10

        System.out.println(".......................");



        int a2=10 , b2=20;//Aritmaetic calculation


        System.out.println("before a2= "+a2);        //10
        System.out.println("before b2= "+b2);        //20
        System.out.println(".......................");

        a2=a2+b2;                                         //a=30,b=20
        b2=a2-b2;                                         //a=30,b=10
        a2=a2-b2;                                         //a=20,b=10


        System.out.println("after a2= "+a2);        //20
        System.out.println("after b2= "+b2);        //10

    }






}
