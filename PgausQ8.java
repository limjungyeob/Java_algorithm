import java.util.Scanner;

public class PgausQ8 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의값: "); int n = stdIn.nextInt();
        int sum= (n+1)*(n/2);
        if(n%2!=0){
            sum+=(n+1)/2;
        }
        System.out.println("합은"+sum);
    }
}
