package P1;
import java.util.Scanner;

public class PgausQ7 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("1부터 n까지의 합을 구합니다.");
            System.out.print("n의값: "); int n = stdIn.nextInt();
            int sum=0;

            for(int i=1;i<=n;i++){
                sum+=i;
            }
            System.out.println("합은"+sum);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
