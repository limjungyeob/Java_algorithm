package P4;

import java.util.Scanner;

import P4.DeckIntQueue.EmptyDeckIntQueueException;
import P4.DeckIntQueue.OverflowDeckIntQueueException;
import chap04.IntQueue.EmptyInQueueException;

public class DeckIntQueueTester {
    static String a;
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        DeckIntQueue s= new DeckIntQueue(64);   //최대 64개를 인큐할 수 있는 큐
        try {
            while(true){
                System.out.println("현재 데이터 수:"+s.size()+"/"+s.capacity());
                System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (5)탐색 (0)종료 :");
                int menu = stdIn.nextInt();
                if(menu == 0) break;
                String f="front";
                String r="rear";
                int x;
                switch(menu){
                    case 1: //인큐
                        try {
                            System.out.print("front와 rear을 선택하세요: ");
                            a=stdIn.next();
                            if(a.equals(f)){
                                System.out.print("데이터:");
                                x=stdIn.nextInt();
                                s.Frontenqueue(x);
                            }else if(a.equals(r)){
                                System.out.print("데이터:");
                                x=stdIn.nextInt();
                                s.Rearenqueue(x);
                            }else{
                                System.out.println("잘못 적었습니다.");
                                break;
                            }
                        } catch (OverflowDeckIntQueueException e) {
                            System.out.println("큐가 가득 찼습니다.");
                        }
                    break;

                    case 2: //디큐
                        try {
                            System.out.print("front와 rear을 선택하세요: ");
                            a=stdIn.next();
                            if(a.equals(f)){
                                x=s.Frontdeque();
                            }else if(a.equals(r)){
                                x=s.Reardeque();
                            }else{
                                System.out.println("잘못 적었습니다.");
                                break;
                            }
                            System.out.println("디큐한 데이터는 "+x+"입니다.");
                        } catch (EmptyInQueueException e) {
                           System.out.println("큐가 비어있습니다.");
                        }
                        break;
                    case 3: //피크
                        try {
                            System.out.print("front와 rear을 선택하세요: ");
                            a=stdIn.next();
                            if(a.equals(f)){
                                x=s.Frontpeek();
                                System.out.println("피크한 데이터는 "+x+"입니다.");
                            }else if(a.equals(r)){
                                x=s.Rearpeek();
                                System.out.println("피크한 데이터는 "+x+"입니다.");
                            }else{
                                System.out.println("잘못 적었습니다.");
                                break;
                            }
                            
                        } catch (EmptyDeckIntQueueException e) {
                            System.out.println("큐가 비어 있습니다.");
                        }
                        break;
                    case 4: //덤프
                        s.dump();
                        break;
                    case 5: //탐색
                        System.out.print("검색할 데이터: ");
                        x=stdIn.nextInt();
                        int a=s.search(x);
                        if(a>0){
                            System.out.println("데이터는 "+a+"번째 큐에 있습니다.");
                        }else{
                            System.out.println("검색에 실패했습니다.");
                        }
                }
            
            
            }
        }catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}

