package chap05;

import java.util.Scanner;

import chap04.IntStack;

public class RecurX2 {
    static void recur(int n) {
        IntStack s = new IntStack(n);
        while (true) {
          if (n > 0) {
            s.push(n);
            n = n - 1;
            continue;
          }
          
          if (s.isEmpty()!=true) {
            n = s.pop();
            System.out.println(n);
            n = n - 2;
            continue;
          }
          break;
        }
      }
      
      // recur(4)
      // stack: 4 3 2 1 
      // sysout(1) n = -1
      // sysout(2) n = 0
      // sysout(3) n = 1
      // s.push(1) -> stack: 4 1
      // sysout(4) n = 2
      // s.push(2) -> stack 1 2
      // sysout(1) n = -1 (stack 1)
      // sysout(2) n = 0 (stack)
      public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("정수를 입력하세요s: ");
            int x=stdIn.nextInt();

            recur(x);
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
