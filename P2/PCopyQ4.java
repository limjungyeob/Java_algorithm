package P2;

import java.util.Scanner;

public class PCopyQ4 {
    static void copy(int[] a, int[] b){
        int num = a.length<=b.length ? a.length : b.length;

        for(int i=0;i<num;i++){
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {

        Scanner stdId= new Scanner(System.in);

        try {
            System.out.print("b의 요솟수는 : ");
		int b_1 = stdId.nextInt(); 
		int[] b = new int[b_1]; 
		for (int i = 0; i < b_1; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdId.nextInt();
		}

        int a[] = new int[b_1];

        copy(a, b);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        } catch (Exception e) {
            
        }finally{
stdId.close();
        }
        
    }
}
