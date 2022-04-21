package P3;

import java.util.Scanner;


public class PBinarySearchQ5 {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n, int key){
        int pl = 0; //검색 범위의 첫 인덱스
        int pr = n-1;   //검색 범위의 끝 인덱스

        System.out.print("  |");
            for(int i=0;i<n;i++){
                System.out.printf("%2d",i);
            }
            System.out.println();
        System.out.print("--+");
        for(int i=0;i<n;i++){
            System.out.print("--");
        }
        System.out.println();
        do{
            int pc = (pl+pr)/2; //중앙 요소의 인덱스
            System.out.print("  |");
            for(int i=0;i<n;i++){
                if(i==pl){
                    System.out.print("<-");
                }else if(i==pc){
                    System.out.print(" +");
                }else if(i==pr){
                    System.out.print("->");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
            System.out.print(pc+" |");
            for(int i=0;i<n;i++){
                System.out.printf("%2d",a[i]);
            }
            System.out.println();
            if(a[pc] == key){
                int idx1=pc;
                while(a[idx1]==key){
                    idx1--;
                }
                if(a[pc] == a[pc-1]||a[pc]==a[pc+1]){
                    System.out.print("  |");
                        for(int i=0;i<n;i++){
                            if(i==idx1+1){
                                System.out.print(" +");
                            }else{
                                System.out.print("  ");
                            }
                        }
                    System.out.println();
                }
                return idx1+1;
            }
            else if(a[pc] < key)
                pl = pc+1;  //검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc-1;  //검색 범위를 앞쪽 절반으로 좁힘
            
        }while(pl <=pr);

        return -1;  //검색 실패!
    }

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
            
            /*test code
            int[] x = {1,3,5,7,7,7,7,8,8,9,9};
            int num=11;
            int ky=7; 
           
            */
            

             int idx = binSearch(x, num, ky);
            if(idx == -1)
                System.out.println("그 값의 요소가 없습니다.");
            else
                System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
