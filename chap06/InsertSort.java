package chap06;
//단순 삽입정렬
public class InsertSort {
    //단순 삽입정렬
    static void insertSort(int[] a, int n){
        for(int i=1;i<n;i++){
            int j;
            int tmp=a[i];
            for(j=i;j>0&&a[j-1]>tmp;j--){
                a[j] =a[j-1];
            }
            a[j] =tmp;
        }
    }
    public static void main(String[] args) {
        System.out.println("단순 삽입 정렬");
        int nx=7;
        int x[] = {22,5,11,32,120,68,70};
        insertSort(x, nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}
