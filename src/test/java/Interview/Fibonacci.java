package Interview;

public class Fibonacci {
    public static void main(String[] args) {


        int count=8;
        int pre1=0,pre2=1;
        System.out.println("Fibonachi series of " + count+" numbers");

        for (int i= 1; i <count; i++) {

            System.out.print(pre2+" ");
            //On each iteration, we are assigning second number to the first number
            //assigning the sum of last two numbers to the second number

            int sumOfPrewTwo;

            sumOfPrewTwo=pre1+pre2;
            pre1=pre2;
            pre2=sumOfPrewTwo;











        }
    }
}
