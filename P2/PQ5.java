package P2;

import java.util.Scanner;

public class PQ5 {

    static void Rcopy(int[] a,int[] b){
        int num = a.length<=b.length ? a.length : b.length;
        for(int i=0;i<num;i++){
            a[i] = b[b.length -i -1];
        }
    }
    public static void main(String[] args) {
        Scanner stdId= new Scanner(System.in);

        System.out.print("b의 요솟수는 : ");
		int b_1 = stdId.nextInt(); 
		int[] b = new int[b_1]; 
		for (int i = 0; i < b_1; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdId.nextInt();
		}

        int a[] = new int[b_1];

        Rcopy(a, b);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
