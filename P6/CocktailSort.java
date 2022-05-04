package P6;

import java.util.Scanner;

public class CocktailSort {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
    // 양방향 버블정렬(셰이커정렬)
	static void shakerSort(int[] a, int n) {
		int left = 0;
		int right = n - 1;
		int last = right;
        int ccnt = 0; // 비교횟수
		int scnt = 0; // 교환횟수
        int i=0;

		while (left < right) {
            System.out.printf("패스%d：\n", i++);
			for (int j = right; j > left; j--) {
				for (int m = 0; m < n - 1; m++){
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                }
				System.out.printf("%3d\n", a[n - 1]);
				ccnt++;
				if (a[j - 1] > a[j]) {
					scnt++;
					swap(a, j - 1, j);
					last = j;
				}
			}
			left = last;

			for (int j = left; j < right; j++) {
				for (int m = 0; m < n - 1; m++){
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j] > a[j+1]) ? '+' : '-');
                }
				System.out.printf("%3d\n", a[n - 1]);
				ccnt++;
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					last = j;
					scnt++;
				}
			}
			right = last;
			for (int m = 0; m < n; m++){
				System.out.printf("%3d  ", a[m]);
            }
			System.out.println();
			
		}
		System.out.println("비교를 " + ccnt + "회 했습니다.");
		System.out.println("교환를 " + scnt + "회 했습니다.");
	}
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("셰이커 정렬");
            int nx = 7;
            int[] x = {9,1,3,4,6,7,8};

            shakerSort(x, nx);  //배열 x를 셰이커 정렬합니다.
            
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
