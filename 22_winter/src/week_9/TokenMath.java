package week_9;
import java.util.StringTokenizer;
public class TokenMath {

    public static void main(String[] args) {



        String token;

        String mathStr = "2.0*3.0-((4.0+5.0)*2.0)-4.0=";

        double result = 0;

        StringTokenizer str = new StringTokenizer(mathStr,"+*-/",true);

        String printStr="";

        int i = 0;

        while(str.hasMoreTokens()){

            token = str.nextToken();

            if(i==0) printStr = String.format("%s %s %s",printStr," " ,token);

            if(token.equals("=")){

                System.out.println(result);

                printStr = String.format("%s %s %s",printStr," " ,token);

            }

            token = token.replaceAll("[()=]","");

            if(i==0)   result = Double.parseDouble(token);



            i+=1;

            if(token.equals("+")){

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = str.nextToken();

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = token.replaceAll("[()=]","");

                result += Double.parseDouble(token);

            }

            else if(token.equals("*")){

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = str.nextToken();

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = token.replaceAll("[()=]","");

                result += Double.parseDouble(token);

            }

            else if(token.equals("/")){

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = str.nextToken();

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = token.replaceAll("[()=]","");

                result += Double.parseDouble(token);

            }

            else if(token.equals("-")){

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = str.nextToken();

                printStr = String.format("%s %s %s",printStr," " ,token);

                token = token.replaceAll("[()=]","");

                result += Double.parseDouble(token);

            }



        }

        System.out.println(result);

        System.out.println(printStr);

    }

}