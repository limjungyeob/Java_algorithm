package P2;

import java.util.Scanner;

//그 해 경과 일 수를 구함
public class PQ11 {
    //각 달의 일수
    static int[][] mdays = {
        {31,28,31,30,31,30,31,31,30,31,30,31},  //평년
        {31,29,31,30,31,30,31,31,30,31,30,31},  //윤년
    };
    int y;  //년
    int m;  //월
    int d;  //일
   //생성자
    PQ11(int y,int m,int d){
            this.y = y;
            this.m = m;
            this.d = d;

    }
    PQ11 after(int n){   //앞의 날짜를 반환
        PQ11 temp = new PQ11(this.y, this.m, this.d);   //생성자를 이용하여 temp(y,m,d) 객체를 생성
        if(n<0)
            return (before(-n));  //n이 0보다 작으면 before 메소드에 -n을 반환
    
        temp.d+=n;  //생성자 temp의 d를 n과 더함.

        /*
        3월이 31일이라고 가정하여, 입력값이 n이 15일 temp.d가 1일이라하면 합이 16일이여서 while문을 빠져나가 
        temp.d가 16일이 되어 반환.
        그렇지 않고 입력값 n이 18일 temp.d가 15일이라하면 합이 33일이 되어 while문의 조건문이 true로 되어
         해당 월인 31일을 빼서 temp.d를 반환.
        if문은 해당 월이 12월이라하면 년수를 1더하고, 월수를 1로 변환.
        그리고 temp값을 반환
        
        또한 while문에 조건문이 참으로 주어지면 if문에서 temp.m이 12보다 작아도 temp.m이 1증가
        그래서 if문에 조건문이 거짓이어도 temp.m이 1증가하고 temp반환
        */
        while(temp.d>mdays[isLeap(temp.y)][temp.m-1]){  
            temp.d-=mdays[isLeap(temp.y)][temp.m-1];
            if(++temp.m>12){
                temp.y++;
                temp.m=1;
            }
        }
        return temp;
    }
    /*
    위의 after 메소드랑 비슷하게 작동 
    */
    PQ11 before(int n){
        PQ11 temp = new PQ11(this.y, this.m, this.d);
        if(n<0)
            return (after(-n));
        //일반적인 경우 temp.d가 -가 안나오는 경우는 temp.
        temp.d-=n;
        while(temp.d<1){
            if(--temp.m<1){
                temp.y--;
                temp.m=12;
            }
            temp.d+=mdays[isLeap(temp.y)][temp.m-1];
        }
        return temp;
    
    }
    
    
    //서기 year년은 윤년인가? (윤년 : 1/ 평년 : 0)
    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 !=0 || year % 400 ==0) ? 1:0;
    }
    

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            int retry;  //재시작.

            System.out.println("날짜를 입력하세요.");

            do{
                System.out.print("년: "); int year = stdIn.nextInt(); //년
                System.out.print("월: "); int month = stdIn.nextInt();  //월
                System.out.print("일: "); int day = stdIn.nextInt();    //일
                PQ11 date = new PQ11(year, month, day);

                System.out.print("몇일 뒤,전의 날짜를 알고싶나요.");
                int n = stdIn.nextInt();

                PQ11 d1 = date.after(n);

                System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.",n, d1.y, d1.m, d1.d);

                PQ11 d2 = date.before(n);

                System.out.printf("%d일 전의 날짜는 %d년 %d월 %d일입니다.",n, d2.y, d2.m, d2.d);
                

                System.out.print("한 번 더 할까요?(1.예/0.아니오): ");
                retry=stdIn.nextInt();
            }while(retry == 1);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
