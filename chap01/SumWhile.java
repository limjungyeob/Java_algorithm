package chap01;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.println("1부터 n까지의 합을 구합니다.");
            System.out.print("n의값: "); int n = stdIn.nextInt();
            System.out.println();
            int sum = 0;
            /* int i=1;

            while(i<=n){
                sum+=i;
                i++;
            }
            */

            for(int i=1; i<=n;i++){
                sum+=i;
            }
            System.out.println("1부터 "+n+"까지의합은 "+sum+"입니다.");
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
