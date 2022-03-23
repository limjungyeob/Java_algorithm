import java.util.Scanner;

public class PQ16 {

    static void triangleLU(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j<0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRU(int n){

    }
    static void triangleRB(int n){

    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
    System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다. ");
    int n;
    do{
        System.out.print("몇단 삼각형입니까? : ");
        n=stdIn.nextInt();
    }while(n <=0);

        triangleLU(n);

    }
    
}
