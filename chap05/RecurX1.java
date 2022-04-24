package chap05;

import java.util.Scanner;

public class RecurX1 {
    static void recur(int n){
        while(n>0){
            recur(n-1);
            System.out.println(n);
            n=n-2;
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("정수를 입력하세요s: ");
            int x=stdIn.nextInt();

            recur(x);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
