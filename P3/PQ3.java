package P3;

import java.util.Scanner;

public class PQ3 {
    
    static void searchIdx(int[] a,int n, int key, int[] idx){
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i] == key){
                idx[i] = i;
                count++;
            }
        }
        for(int j=0;j<idx.length;j++){
            if(idx[j]>0){
                System.out.println("찾으시는 수는 배열["+j+"]번째에 있습니다.");
            }
        }
        System.out.println("찾은 수는 "+count+"개입니다.");
        
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("요솟수: ");
            int num=stdIn.nextInt();
            int[] x = new int[num+1];
            int[] idx = new int[num];
            for(int i=0;i<num;i++){
                System.out.print("x["+i+"]:");
                x[i] = stdIn.nextInt();
            }

            System.out.print("검색할 값: ");    //키 값을 입력
            int ky = stdIn.nextInt();
            searchIdx(x,num,ky,idx);
            

            
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
