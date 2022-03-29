package P1;
import java.util.Scanner;

public class PminQ3 {
    static int min(int a, int b, int c,int d){
        int min=a;
        if(b<min) min = b;
        if(c<min) min = c;
        if(d<min) min = d;
        return min;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("a의 값 : "); int a = stdIn.nextInt();
        System.out.print("b의 값 : "); int b = stdIn.nextInt();
        System.out.print("c의 값 : "); int c = stdIn.nextInt();
        System.out.print("d의 값 : "); int d = stdIn.nextInt();
        System.out.println("최솟값은 : "+ min(a,b,c,d));
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        

    }
}
