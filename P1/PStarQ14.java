package P1;
import java.util.Scanner;

public class PStarQ14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("단 수:");
            int n=stdIn.nextInt();

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    System.out.print("* ");
            }
            System.out.println();

            }
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
