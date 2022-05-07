package P6;
//셸 정렬(버전2,h의 값은..,40,13,4,1)
public class ShellSort2Count {
    //셸 정렬
    static int shellSort2(int[] a,int n){
        int count=0;    //옮김횟수
        int h;
        for(h=1; h<n/9; h=h*3+1)
            ;
    
        for( ; h>0; h /=3){
            for(int i=h; i<n; i++){
                int j;
                int tmp = a[i];
                for(j = i-h; j >= 0 && a[j] > tmp; j-=h){
                    a[j+h] = a[j];
                    count++;
                }

                a[j+h] = tmp;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int nx = 7;
        int[] x = {22,5,11,32,120,68,70};
        int count=shellSort2(x, nx);
        System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++){
			System.out.println("x[" + i + "]＝" + x[i]);
        }    
        System.out.println("옮긴횟수는 "+count+"회입니다.");
    }

}
