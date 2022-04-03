package P3;

import java.util.Scanner;

public class PQ1 {
    static int seqSearchSen(int[] a, int n, int key){

        int i=0;

        a[n] = key; //보초를 추가

        for(;i<n;i++){
            if(a[i] == key)
                break;
        }

        return i == n ? -1:i;      
        //while문에 의한 반복이 완료되면 찾은 값이 배열의 원래 데이터인지 아니면 보초인지 판단 i가 n이면 값이 보초이므로 -1반환.

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
