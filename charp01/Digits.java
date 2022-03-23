package charp01;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int var1;

        System.out.println("2자리의 정수를 입력하세요.");

        do{
            System.out.print("입력: ");
            var1= stdIn.nextInt();
        }while(var1<10||var1>99);

        System.out.println("변수는 :"+var1);
    }
}
