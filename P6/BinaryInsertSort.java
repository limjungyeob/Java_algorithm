package P6;
//이진 삽입 정렬
public class BinaryInsertSort {
    static void binaryInsertSort(int[] a, int n){
        for(int i=1;i<n;i++){
            int key = a[i];
            int pl=0;   //검색 범위 맨 앞의 인덱스
            int pr = i-1;   //검색 범위 맨 뒤의 인덱스
            int pc;         //중앙의 인덱스
            int pd;         //삽입하는 위치의 인덱스

            do{
                pc=(pl+pr)/2;
                if(a[pc]==key){  //검색 성공
                    break;
                }else if(a[pc]<key){
                    pl=pc+1;
                }else{
                    pr=pc-1;
                }
            }while(pl<=pr);
                pd=(pl<=pr)?pc+1:pr+1;

                for(int j=i; j>pd; j--){
                    a[j]= a[j-1];
                }
                a[pd] =key;
            }
        }
    public static void main(String[] args) {
        System.out.println("이진 삽입 정렬");
        int nx = 7;
        int[] x = {6,4,8,3,1,9,7};
        binaryInsertSort(x, nx);
        System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
    }
}

