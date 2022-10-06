package week_5;

public class Sort_2 {
    public static void main(String[] args){
        System.out.print("sort 결과 : ");

        String temp;
        for (int i = 1; i < args.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if(Double.parseDouble(args[i]) < Double.parseDouble(args[j])){
                    temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                    i = j;
                }
            }
        }
        for (int i =0; i < args.length; i++){
            System.out.print(args[i]+" ");
        }
    }
}