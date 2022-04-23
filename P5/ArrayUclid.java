package P5;

import java.util.Scanner;

public class ArrayUclid {
    static int gcd(int x,int y){
        if(y==0){
            return x;
        }else{
            return gcd(y,x%y);
        }
    }
    static int arrGcd(int x[]){
        int result =0;
        for(int i=0;i<x.length;i++){
            result = gcd(result,x[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner stdIn= new Scanner(System.in);

        try {
            System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
		    int num;
		        do {
			        num = stdIn.nextInt();
		        } while (num <= 1);
            int x[] = new int[num];
            for(int i=0; i<x.length;i++){
                System.out.print("x["+i+"]=");
                x[i] = stdIn.nextInt();
            }
            System.out.println("최대공약수는 "+arrGcd(x)+"입니다.");
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
