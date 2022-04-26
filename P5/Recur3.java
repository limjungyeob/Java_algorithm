package P5;
//메소드 recur3의 비재귀적구현

import java.util.Scanner;

public class Recur3 {
    //메소드 recur3의 비재귀적 구현
    static void Nonrecur3(int n){
        int[] nstk = new int[4];  //n을 쌓아둘 배열
        int[] sstk = new int[4];  //각 n의 step을 대응해줄 배열
        int ptr = -1;   //n과 step을 대응할 인덱스 ptr 혹은 배열에 저장할 포인터
        int step = 0;

        while(true){
            if(n>0){
                //일단 막바지까지 n을 쭉 스택에 쌓는다.
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = step; //step을 부여한다

                if(step == 0){    //0스탭이면 recur(n-1)돌리기
                    n --;
                }else if(step == 1){  //1스탭이면 recur(n-2)돌리기
                    n = n-2;    //n을 n-2값으로 갱신
                    step=0;       //갱신 recur(n)을 돌리기 위해 step은 0으로 초기화
                }
                continue;
            }
            do{
                n=nstk[ptr];    //가장 최근의 n을 꺼내고
                step=sstk[ptr--]+1;   //위의 if문을 빠져나왔으니 최근 step을 꺼내 +1
                //왜 ptr--하는가?
                //1.step2인 경우 print 하고나서 다시 상위의 n으로 올라와야한다.
                //2. ptr<0과 관련있다. 처리할 n이 더이상 있는지 판단하기 위함
                if(step == 2){    //recur(n-1)를 마치고 온 n이 있다면, 
                    System.out.println(n);  //출력한다.
                    if(ptr<0){
                        return;
                    }
                }
            }while(step == 2);
        }
    }
    static void recur3(int n){
        if(n>0){
            recur3(n-1);
            recur3(n-2);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("정수를 입력하세요 : ");
            int x = stdIn.nextInt();
            Nonrecur3(x);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
