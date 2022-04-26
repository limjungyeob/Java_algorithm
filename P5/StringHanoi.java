package P5;

import java.util.Scanner;

public class StringHanoi {
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no,int x,int y){
        String[] Hanoi =   {"A기둥","B기둥","C기둥"};
        if(no>1){
            move(no-1,x,6-x-y);
        }
        System.out.println("원반["+no+"]을 "+Hanoi[x-1]+"에서 "+Hanoi[y-1]+"으로 옮김 ");
        if(no>1){
            move(no-1,6-x-y,y);
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.println("하노이의 탑");
            System.out.print("원반 개수");
            int n=stdIn.nextInt();
            move(n, 1, 3);  //1번 기둥의 n개의 원반을 3번 기둥으로 옮김.
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
