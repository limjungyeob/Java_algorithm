package P6;

import java.util.Scanner;

public class FsortDosu2 {
    //도수 정렬(0이상 max이하의 값을 입력합니다.)
    static void fSort(int[] a, int n, int min, int max){
        int[] f = new int[max-min+2];   //누적도수
        int[] b = new int[n];       //작업용 목적 배열
        System.out.println("1단계 도수분포표 만들기");  //1단계
        for(int i = 0; i<n; i++){      
            for(int k=0; k<=max; k++){
                System.out.printf("%3d",f[k]);
            }
            System.out.println();
            f[a[i]-min]++;
        }          
        for(int k=0; k<=max; k++){
            System.out.printf("%3d",f[k]);
        }
        System.out.println();

        System.out.println("2단계 누적도수분포표 만들기");  //2단계
        for(int i = 1; i<= max-min; i++){   
            for(int k=0; k<=max; k++){
                System.out.printf("%3d",f[k]);
            }
            System.out.println();
            f[i] += f[i-1]; 
        }   

        for(int k=0; k<=max; k++){
            System.out.printf("%3d",f[k]);
        }
        System.out.println();

        System.out.println("3단계 목표도수분포표(정렬) 만들기");    //3단계
        for(int i = n-1; i>=0; i--){ 
            for(int k=0; k<n; k++){
                System.out.printf("%3d",b[k]);
            }
            System.out.println();   
             b[--f[a[i]-min]] = a[i];    
        }    

        for(int k=0; k<n; k++){
            System.out.printf("%3d",b[k]);
        }
        System.out.println();
        System.out.println("4단계 배열 복사");  //4단계
        for(int i = 0; i<n; i++){  
            a[i] = b[i];
        }       
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.println("도수 정렬");
            System.out.print("요솟수: ");
            int nx = stdIn.nextInt();
            int[] x = new int[nx];

            for(int i = 0; i<nx; i++){
                do{
                    System.out.print("x["+i+"]:");
                    x[i]=stdIn.nextInt();
                }while(x[i]<0);
            }

            int max = x[0];
            for(int i =1; i <nx; i++){
                if(x[i]>max)    max = x[i];
            }
            int min = x[0];
            for(int i=1; i<nx; i++){
                if(x[i]<min)    min = x[i];
            }

            fSort(x, nx, min,max);
            System.out.println("오름차순으로 정렬했습니다.");

            for(int i=0; i<nx; i++){
                System.out.println("x["+i+"]="+x[i]);
            }
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
