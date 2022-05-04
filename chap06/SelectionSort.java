package chap06;

import java.util.Scanner;

//선택 정렬
public class SelectionSort {
    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    //단순 선택 정렬
    static void selectionSort(int[] a,int n){
        for(int i=0; i<n-1;i++){
            int min=i;          //아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록합니다.
            for(int j=i+1;j<n;j++){
                if(a[j] < a[min]){
                    min=j;
                }
            }
            swap(a, i, min);
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("단순 선택 정렬");
            int nx = 7;
            int[] x = {22,5,11,32,120,68,70};

            selectionSort(x, nx);  //배열 x를 단순 선택 정렬합니다.
            
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
