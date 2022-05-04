package P6;

import java.util.Scanner;

public class BubbleSortRever {
    
    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //버블 정렬
    static void bubbleSort(int[] a,int n){
        for(int i=n-1; i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("버블 정렬(reverse버젼)");
            int nx = 7;
            int[] x = {22,5,11,32,120,68,70};

            bubbleSort(x, nx);  //배열 x를 버블 정렬합니다.
            
            System.out.println("오름차순으로 정렬했습니다.");

            for(int i=0; i<nx;i++){
                System.out.println("x["+i+"]="+x[i]);
            }
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
