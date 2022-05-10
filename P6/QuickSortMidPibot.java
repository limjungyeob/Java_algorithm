package P6;
// 퀵정렬(임의로 추출한 3요소의 중앙값을 피벗으로 합니다. : 재귀버전)
public class QuickSortMidPibot {
    //a,b,c의 중앙값을 구하여 반환
    static int med3(int a, int b, int c){
        if(a>=b){
            if(b>=c){
                return b;
            }else if(a<=c){
                return a;
            }else{
                return c;
            }
            
        }else if(a>c){
            return a;
        }else if(b>c){
            return c;
        }else{
            return b;
        }
    }
    //배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a,int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    //단순삽입정렬
    static void insertSort(int[] a, int left, int right){
        for(int i=left;i<=right;i++){
            int j;
            int tmp=a[i];
            for(j=i;j>0&&a[j-1]>tmp;j--){
                a[j] =a[j-1];
            }
            a[j] =tmp;
        }
    }
    //퀵 정렬.
    static void quickSort(int[] a,int left,int right){
        if(right-left<9){
            insertSort(a, left, right);
        }else{
        int pl = left; //왼쪽커서
        int pr = right;   //오른쪽 커서
        int x = med3(a[pl], a[(pl + pr) / 2], a[pr]); //배열의 맨 왼쪽값, 중앙값, 맨 오른쪽 값

        System.out.printf("a[%d]~a[%d] : {",left,right);
        for(int i=left;i<right;i++){
            System.out.printf("%d, ",a[i]);
        }
        System.out.printf("%d}\n",a[right]);
        do{
            while(a[pl]< x) {pl++;}
            while(a[pr]> x) {pr--;}
            if(pl<=pr){
                swap(a, pl++, pr--);
            }
        }while(pl <= pr);
        if(pr-left < right -pl){
            int tmp;
            tmp =left;
            left=pl;
            pl=tmp;
            tmp=right;
            right=pr;
            pr=tmp;
        }
        if(left<pr) quickSort(a, left, pr);
        if(pl<right) quickSort(a, pl, right);
        }
    }

    public static void main(String[] args) {
       
        int x[] = {5,8,4,2,6,1,3,9,7};
        int nx = 9;
        quickSort(x,0, nx-1);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}

