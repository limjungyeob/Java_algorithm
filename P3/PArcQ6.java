package P3;


import java.util.Arrays;
import java.util.Scanner;

public class PArcQ6 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

    try {
        
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: "); x[0] = stdIn.nextInt();
        for(int i=1;i<num;i++){
            do{
                System.out.print("x["+i+"]:"); x[i] = stdIn.nextInt();

            }while(x[i] < x[i-1]);  //바로 앞의 요소보다 작으면 다시 입력.
        }

        System.out.print("검색할 값: ");    //키 값을 입력
        int ky= stdIn.nextInt();
        int idx = Arrays.binarySearch(x,ky);
        if(idx<0)
            System.out.println("그 값의 요소가 없습니다."+"반환 인덱스는 :"+idx);
        else
            System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
    }catch (Exception e) {

    }finally{
    stdIn.close();
    }
    
        
    }
}
