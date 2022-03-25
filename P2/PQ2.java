package P2;

import java.util.Scanner;

public class PQ2 {
    static void swap(int[] a,int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    static void reverse(int[] a){
        for(int i=0;i<a.length/2;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
            System.out.println("a[" + i +"]과(와) a["+(a.length -i -1)+"]를 교환합니다.");;
            swap(a, i, a.length -i -1);
           

        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for(int i=0; i<num;i++)
        {
            System.out.print("x["+i+"] : ");
            x[i]=stdIn.nextInt();
        }

        reverse(x);

       

        
    }
    }

