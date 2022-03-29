package P1;
import java.util.Scanner;

public class PmaxQ1 {
    static int max4(int a, int b, int c, int d){
        int max=a;
        if(b>max) max=b;
        if(c>max) max =c;
        if(d>max) max =d;
        return max;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.print("a의 값 : "); int a = stdIn.nextInt();
            System.out.print("b의 값 : "); int b = stdIn.nextInt();
            System.out.print("c의 값 : "); int c = stdIn.nextInt();
            System.out.print("d의 값 : "); int d = stdIn.nextInt();
            System.out.println("최댓값은: "+max4(a, b, c, d));
    
        } catch (Exception e) {
           
        }finally{
            stdIn.close();
        }
     }   
        
}
