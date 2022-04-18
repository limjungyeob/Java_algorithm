package P4;

import java.util.Scanner;

public class PQ3 {
    static String a;
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Q3Stack s = new Q3Stack(64);
        try {
           while(true){
            System.out.println("현재 A데이터 수 :"+s.sizeA()+"/"+s.capacity()+"현재 B데이터 수:"+s.sizeB()+"/"+s.capacity());

            System.out.print("(1)푸시 (2)팝 (3)피크  "+"(4)덤프 (5)탐색 (6)초기화 :"+ "(7)index (0)종료: ");

            int menu = stdIn.nextInt();
            if(menu==0) break;
            
            String A = "a";
            String B = "b";
            int x;
            switch(menu){
                case 1: //푸시
                    
                    System.out.print("a스택과 b스택중 선택하세요:");
                    a=stdIn.next();
                    if(a.equals(A)){
                        System.out.print("데이터 :");
                        x = stdIn.nextInt();
                        try {
                            s.pushA(x);
                        } catch (IntStack.OverflowIntStackException e) {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        break;
                    }else if(a.equals(B)){
                        System.out.print("데이터 :");
                        x = stdIn.nextInt();
                        try {
                            s.pushB(x);
                        } catch (IntStack.OverflowIntStackException e) {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        break;
                    }else{
                        break;
                    }

                case 2: //팝
                    
                    System.out.print("a스택과 b스택중 선택하세요.");
                    a=stdIn.next();
                    if(a.equals(A)){
                            try {
                                s.popA();
                                
                            } catch (IntStack.OverflowIntStackException e) {
                            System.out.println("스택이 가득 찼습니다.");
                        
                            }
                        break;
                    }else if(a.equals(B)){
                            try {
                                s.popB();
                            } catch (IntStack.OverflowIntStackException e) {
                                System.out.println("스택이 가득 찼습니다.");
                            }
                        break;
                    }else{
                        break;
                    }
                case 3: //피크
                    System.out.print("a스택과 b스택중 선택하세요.");
                    a=stdIn.next();
                    if(a.equals(A)){
                        try {
                            x=s.peekA();
                            System.out.println("피크한 데이터는"+x+"입니다.");
                        } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    
                        }
                        break;
                    }else if(a.equals(B)){
                        try {
                            x=s.peekB();
                            System.out.println("피크한 데이터는"+x+"입니다.");
                        } catch (IntStack.OverflowIntStackException e) {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        break;
                    }else{
                        break;
                    }
                

                case 4: //덤프
                    s.dumpA();
                    s.dumpB();
                    break;

                case 5: //탐색
                System.out.print("a스택과 b스택중 선택하세요.");
                a=stdIn.next();
                if(a.equals(A)){
                    System.out.print("검색할 데이터: ");
                    x=stdIn.nextInt();
                    int n = s.indexOfA(x);
                    if(n >= 0){
                        System.out.println("검색할 데이터는 "+(s.sizeA()-n)+"번째 있습니다.");
                    }else{
                        System.out.println("그 데이터는 없습니다.");
                    }
                    break;
                }else if(a.equals(B)){
                    System.out.print("검색할 데이터: ");
                    x=stdIn.nextInt();
                    int n = s.indexOfB(x);
                    if(n >= 0){
                        System.out.println("검색할 데이터는 "+(n-s.sizeB())+"번째 있습니다.");
                    }else{
                        System.out.println("그 데이터는 없습니다.");
                    }
                    break;
                }else{
                    break;
                }
                case 6: //clear
                    s.clear();
                    break;
                case 7: //index
                    System.out.println("A용량: "+s.capacity());
                    System.out.println("A데이터 수: "+s.sizeA());
                    System.out.println("A는비어"+(s.isEmptyA()?"있습니다.":"있지 않습니다."));
                    System.out.println("A는꽉차"+(s.isFullA()?"있습니다.":"있지 않습니다."));
                    System.out.println("B용량: "+s.capacity());
                    System.out.println("B데이터 수: "+s.sizeB());
                    System.out.println("B는비어"+(s.isEmptyB()?"있습니다.":"있지 않습니다."));
                    System.out.println("B는꽉차"+(s.isFullB()?"있습니다.":"있지 않습니다."));
                    break;
            }
            
            } 
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
        
    }
}
