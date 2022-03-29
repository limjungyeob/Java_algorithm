package P1;
import java.util.Scanner;

public class Pinput2Q9 {
    static int sumof(int a,int b){
        int max,min,sum=0;
        if(a>b){
            max=a;
            min=b;
        }else{
            max=b;
            min=a;
        }
        for(int i=min;i<=max;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.print("a의 값 : "); int var1 = stdIn.nextInt();
            System.out.print("b의 값 : "); int var2 = stdIn.nextInt();
            System.out.println("a부터 b까지의 합은:"+sumof(var1, var2));
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
