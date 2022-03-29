package charp01;

import java.util.Scanner;

public class SumForPos {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            int n;

            System.out.println("1부터 n까지의 합을 구합니다.");

            do{
                System.out.print("n의값: ");
                n=stdIn.nextInt();
            }while(n<=0);

            int sum = 0;
            for(int i =0; i<=n;i++){
                sum += i;
            }
            System.out.println("합은"+sum);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }


}
