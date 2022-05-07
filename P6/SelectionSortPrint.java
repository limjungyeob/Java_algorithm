package P6;

import java.util.Scanner;

//단순 선택 정렬.
public class SelectionSortPrint {
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
            for(int j=i+1; j<n; j++){
                if(a[j] < a[min]){
                    min=j;
                }
            }

            for(int m=0; m<n; m++){
                System.out.print((m == i) ? "  * " : (m == min) ? "  + " : "    ");
            }

            System.out.println();

            for(int m=0; m<n; m++){
                System.out.printf("%3d ", a[m]);
            }
            System.out.println("\n");
            swap(a, i, min);    //미정렬된 부분 머리요소와  최소 요소를 교환
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("단순 선택 정렬");
            int nx = 7;
            int[] x = {6,4,8,3,1,9,7};

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
