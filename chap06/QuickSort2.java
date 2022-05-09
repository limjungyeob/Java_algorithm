package chap06;

import P4.IntStack;

//퀵 정렬(비재귀적버전)
public class QuickSort2 {
    //배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a,int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void quickSort2(int[] a, int left, int right){
        IntStack lStack = new IntStack(right-left+1);
        IntStack rStack = new IntStack(right-left+1);

        lStack.push(left);
        rStack.push(right);
        System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack:");
		lStack.dump();
		System.out.print("Rstack:");
		rStack.dump();
        while(lStack.isEmpty() != true){
            int pl = left = lStack.pop();   //왼쪽 커서
            int pr = right = rStack.pop();  //오른쪽 커서
            int x = a[(left+right)/2];      //피벗

            do{
                while(a[pl]< x) {pl++;}
                while(a[pr]> x) {pr--;}
                if(pl<=pr){
                    swap(a, pl++, pr--);
                }
            }while(pl <= pr);
            if(left < pr){
                lStack.push(left);      //왼쪽 그룹 범위의
                rStack.push(pr);        //인덱스를 푸시합니다.
                System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		        System.out.print("Lstack:");
		        lStack.dump();
		        System.out.print("Rstack:");
		        rStack.dump();
            }
            if(pl < right){
                lStack.push(pl);        //오른쪽 그룹 범위의
                rStack.push(right);     //인덱스를 푸시합니다.
                System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		        System.out.print("Lstack:");
		        lStack.dump();
		        System.out.print("Rstack:");
		        rStack.dump();
            }

        }
    }
    public static void main(String[] args) {
       
        int x[] = {5,8,4,2,6,1,3,9,7};
        int nx = 9;
        quickSort2(x,0, nx-1);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}
