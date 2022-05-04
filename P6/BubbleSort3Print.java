package P6;

import java.util.Scanner;

//버블 정렬(버전3)
public class BubbleSort3Print {
    //a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void bubbleSort3(int[] a, int n){
        int k = 0;      //a[k]보다 앞쪽은 정렬을 마친 상태
        int ccnt = 0; // 비교횟수
		int scnt = 0; // 교환횟수
        while(k<n-1){
            
            System.out.printf("패스%d：\n", k);
            int last = n-1; //마지막으로 요소를 교환한 위치
            for(int j=n-1;j>k;j--){
                for (int m = 0; m < n - 1; m++){
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                }
				System.out.printf("%3d\n", a[n - 1]);
                ccnt++;
                if(a[j-1]>a[j]){
                    swap(a, j-1, j);
                    last=j;
                    scnt++;
                }
            }
            k=last;
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
		System.out.println("교환를 " + scnt + "회 했습니다.");
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("버블 정렬(버전3)");
            int nx = 7;
            int[] x = {22,5,11,32,120,68,70};

            bubbleSort3(x, nx);  //배열 x를 버블 정렬합니다.
            
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
