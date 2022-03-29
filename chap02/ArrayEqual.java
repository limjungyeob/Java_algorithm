package chap02;

import java.util.Scanner;

public class ArrayEqual {
    static boolean equals(int[] a, int[] b){
        if(a.length != b.length)
            return false;
        for(int i=0;i<a.length;i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.print("a의 요솟수: ");
            int a_1 = stdIn.nextInt();

            int[] a = new int[a_1];

            for(int i=0; i<a_1;i++)
            {
                System.out.print("a["+i+"] : ");
                a[i]=stdIn.nextInt();
            }

            System.out.print("b의 요솟수: ");
            int b_1 = stdIn.nextInt();

            int[] b = new int[b_1];

            for(int i=0; i<b_1;i++){
            System.out.print("b["+i+"] : ");
            b[i]=stdIn.nextInt();
            }

            System.out.println("배열 a와 b는 "+(equals(a, b)? "같습니다" :"같지 않습니다. "));
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
