package chap06;
//셸 정렬(버전2,h의 값은..,40,13,4,1)
public class ShellSort2 {
    //셸 정렬
    static void shellSort2(int[] a,int n){
        int h;
        for(h=1; h<n/9; h=h*3+1)
            ;
    
        for( ; h>0; h /=3){
            for(int i=h; i<n; i++){
                int j;
                int tmp = a[i];
                for(j = i-h; j >= 0 && a[j] > tmp; j-=h){
                    a[j+h] = a[j];
                }

                a[j+h] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int nx = 7;
        int[] x = {22,5,11,32,120,68,70};
        shellSort2(x, nx);
        System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
    }

}
