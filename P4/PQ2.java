package P4;

import java.util.Scanner;

public class PQ2 {
    private static Object push;

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        GenericStack s = new GenericStack(64);  //최대 64개를 푸시할 수 있는 스택
        try {
           while(true){
            System.out.println("현재 데이터 수 :"+s.size()+"/"+s.capacity());

            System.out.print("(1)푸시 (2)팝 (3)피크  "+"(4)덤프 (5)탐색 (6)초기화 :"+ "(7)index (0)종료: ");

            int menu = stdIn.nextInt();
            if(menu==0) break;

            int x;
            switch(menu){
                case 1: //푸시
                System.out.print("데이터 :");
                x = stdIn.nextInt();
                try {
                    push = s.push(x);
                } catch (IntStack.OverflowIntStackException e) {
                    System.out.println("스택이 가득 찼습니다.");
                }
                break;

                case 2: //팝
                try {
                    x=(int) s.pop();
                    System.out.println("팝한 데이터는 "+x+"입니다.");
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어 있습니다.");
                }
                break;

                case 3: //피크
                try {
                    x=(int) s.peek();
                    System.out.println("피크한 데이터는"+x+"입니다.");
                } catch (IntStack.EmptyIntStackException e) {
                    System.out.println("스택이 비어 있습니다.");
                }
                break;

                case 4: //덤프
                    s.dump();
                    break;

                case 5: //탐색
                    System.out.print("검색할 데이터: ");
                    x=stdIn.nextInt();
                    int n = s.indexOf(x);
                    if(n >= 0){
                        System.out.println("검색할 데이터는 "+(s.size()-n)+"번째 있습니다.");
                    }else{
                        System.out.println("그 데이터는 없습니다.");
                    }
                    break;
                case 6: //clear
                    s.clear();
                    break;
                case 7: //index
                    System.out.println("용량: "+s.capacity());
                    System.out.println("데이터 수: "+s.size());
                    System.out.println("비어"+(s.isEmpty()?"있습니다.":"있지 않습니다."));
                    System.out.println("꽉차"+(s.isFull()?"있습니다.":"있지 않습니다."));
                    break;
            }
            
            } 
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
