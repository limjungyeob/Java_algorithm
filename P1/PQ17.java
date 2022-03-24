package P1;
import java.util.Scanner;

public class PQ17 {
    
    static void npira(int n){
        for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= n - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
				System.out.print(' ');
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
				System.out.print('*');
			System.out.println(); 						// 개행(줄변환)
		}
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
    System.out.println("피라미드를 만듭니다.. ");
    int n;
    do{
        System.out.print("양의 정수를 입력하세요.? : ");
        n=stdIn.nextInt();
    }while(n <=0);

        npira(n);

    }
}
