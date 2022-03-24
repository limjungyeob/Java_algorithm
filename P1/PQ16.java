package P1;
import java.util.Scanner;

public class PQ16 {

    static void triangleLU(int n){
        for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= n - i + 1; j++) 	// n-i+1개의 '*'를 나타냄
				System.out.print('*');
			System.out.println(); 					// 개행(줄변환)
		}
        }
    
    static void triangleRU(int n){
        for(int i=1;i<=n;i++){
            for(int j=1; j<=i-1;j++){
                System.out.print(" ");
            }
            for(int y=1;y<=n-i+1; y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRB(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j <= n-i;j++){
                System.out.print(" ");
            }
            for(int y=1;y<=i;y++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
    System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다. ");
    int n;
    do{
        System.out.print("몇단 삼각형입니까? : ");
        n=stdIn.nextInt();
    }while(n <=0);

        //triangleLU(n);
        //triangleRU(n);
        triangleRB(n);

    }
    
}
