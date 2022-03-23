import java.util.Scanner;

public class PQ11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;
        do{
            System.out.print("양의 정수를 입력하세요. : ");
            n = stdIn.nextInt();

        }while(n<=0);
        
        int flag=0;

        while(n>0){
            n/=10;
            flag++;
        }
        System.out.println("자릿수는 "+flag+"입니다.");
    }
   
}
