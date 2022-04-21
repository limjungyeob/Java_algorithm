package P3;

import java.util.Scanner;

public class PSeqSearchPrintQ2 {
    static int seqSearchSen(int[] a, int n, int key){

        int i=0;

        a[n] = key; //보초를 추가
        
        //위의 별찍기 전까지의 출력
        System.out.print("   |");
        for(int k=0;k<n;k++){
            System.out.print(k+" ");
        }
        System.out.print("\n---+");
        for(int j=0;j<n;j++)
        System.out.print("--");
        System.out.println();

        for(;i<n;i++){
            System.out.print("   |");
            for(int j=0;j<i;j++){   //i만큼 공백 띄우기
                System.out.print("  "); 
            }
            System.out.print("*\n");    //별찍고 line feedback
            System.out.print(i+"  |");
            
            for(int j=0;j<n;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
                 if(a[i] == key)
                return i;     
            }
        return -1;   
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("요솟수: ");
            int num=stdIn.nextInt();
            int[] x = new int[num+1];

            for(int i=0;i<num;i++){
                System.out.print("x["+i+"]:");
                x[i] = stdIn.nextInt();
            }

            System.out.print("검색할 값: ");    //키 값을 입력
            int ky = stdIn.nextInt();

            int idx = seqSearchSen(x, num, ky);    //배열 x에서 키 값이 ky인 요소를 검색

            if(idx == -1)
                System.out.println("그 값의 요소가 없습니다.");
            else
                System.out.println(ky+"는 x["+idx+"]에 있습니다.");

            System.out.println();
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
