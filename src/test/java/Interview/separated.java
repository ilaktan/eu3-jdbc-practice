package Interview;

import java.util.Arrays;

public class separated {
    public static void main(String[] args) {
        //const textAbstract = (text) => {
//            if (text == null) {
//                return ''
//            }
//
//            let newText = text
//
//            if (text[text.length - 1] === '/' || text[text.length - 1] === '&') {
//                newText = text.substring(0, text.length - 2)
//            }
//  const arr = newText.split(/&| \//)
//  const result = arr.map((text) => {
//            if (text.length <= 30) {
//      const newText = text
//                return newText
//            }
//            let newText = text.substring(0, 30)
//    const last = newText.lastIndexOf(' ')
//            newText = newText.substring(0, last)
//            return newText
//  })
//            console.log(result)
//            return result
//        }
//
//


        String a = "The quick brown fox jumped over the lazy dog & the end /";
        String b = "";

        extractNum2(a);
        extractNum2(b);

    }


    public static String extractNum(String s) {

        String text = "";
        if (text == null) {
            return "";
        }

        String newText = text;
        if (text.length() - 1 == '/' || text.length() - 1 == '&') {
            newText = text.substring(0, text.length() - 2);

        }

        String [] arr=newText.split("&");
        String result=Arrays.toString(arr);
        text=arr.toString();

        if(arr.length<=30){
            newText=text;

            return newText;
        }

        newText=text.substring(0,30);


        return result;


    }
    public static String extractNum2(String s) {

        String text = "";
        if (text == null) {
            return "";
        }



        if(s.length()<=30){
            text=s;
            System.out.println(text);

        }


        if(s.length()>30){


            text = s.substring(0, 30);
            text = text.substring(0, text.lastIndexOf(" "));

            System.out.println(text);

           text=s.substring(text.length(),s.lastIndexOf(" "));

            text=text.replaceAll("/","");

            for (String part : text.split("&")) {


                System.out.println(part);
            }


            //            let newText = text.substring(0, 30)
//    const last = newText.lastIndexOf(' ')
//            newText = newText.substring(0, last)


        }




        return text;
    }
}



