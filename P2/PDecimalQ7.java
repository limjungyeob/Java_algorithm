package P2;
import java.util.Scanner;

public class PDecimalQ7 {

//입력 받은 10진수를 2진수~36진수로 기수 변환하여 나타냄.

    //정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환합니다.
    static int cardConvR(int x, int r, char[] d){
        int n = ((Integer) x).toString().length(); // 변환 전의 자릿수
		int digits = 0; // 변환 뒤의 자릿수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
		do {
			System.out.printf("   +");
			for (int i = 0; i < n + 2; i++)
				System.out.print('-');
			System.out.println();

			if (x / r != 0)
				System.out.printf(String.format("%%2d | %%%dd    … %%d\n", n), r, x / r, x % r);
			else
				System.out.printf(String.format("     %%%dd    … %%d\n", n), x / r, x % r);
			d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지를 저장
			x /= r;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) { // d[0]~d[digits-1]
			char temp = d[i]; // 를 역순으로 정렬
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = temp;
		}
		return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
         int no;                     //변환하는 정수
        int cd;                    //기수
        int dno;                    //변환 후의 자릿수
        int retry;                  //다시한번
        char[] cno = new char[32];  //변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수 변환합니다.");

        do{
            do{
                System.out.print("변환하는 음이 아닌 정수:");
                no = stdIn.nextInt();
            }while(no<0);

            do{
                System.out.print("어떤 진수를 변환할까요?(2~36) : ");
                cd = stdIn.nextInt();
            }while(cd <2 || cd>36);

            dno = cardConvR(no, cd, cno);

            System.out.print(cd+"진수로는");
            
            for(int i=dno-1;i>=0;i--){
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.println("한 번 더 할까요? (1.예/0.아니오) :");
            retry=stdIn.nextInt();
        }while(retry == 1);    
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
       
    } 
}


