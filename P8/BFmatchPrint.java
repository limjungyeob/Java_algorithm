package P8;

import java.util.Scanner;

public class BFmatchPrint {
    //브루트-포스법으로 문자열을 검색하는 메서드
    static int bfMathch(String txt, String pat){
        int pt = 0; //txt커서
        int pp = 0; //pat커서
        int count = 0;  //비교 횟수
        int k=-1;

        while(pt != txt.length() && pp !=pat.length()){
            if(k == pt-pp){
                System.out.print("    ");
            }else{
                System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
            }

            for (int i = 0; i < txt.length(); i++){
				System.out.print(txt.charAt(i) + " ");
            }
			System.out.println();
            

            for (int i = 0; i < pt * 2 + 4; i++){
				System.out.print(" ");
            }
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

            for (int i = 0; i < (pt - pp) * 2 + 4; i++){
				System.out.print(" ");
            }

            for (int i = 0; i < pat.length(); i++){
				System.out.print(pat.charAt(i) + " ");
            }
			System.out.println();
			System.out.println();
			count++;
            
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt-pp+1;
                pp=0;
            }
        }
        System.out.printf("비교는 %d회였습니다.\n", count);
        if(pp==pat.length()){    //검색성공
            return pt-pp;
        }else{
            return -1;  //검색실패
        }
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("텍스트: ");
            String s1 = stdIn.next();   //텍스트용 문자열

            System.out.print("패턴: ");
            String s2 = stdIn.next();   //패턴용 문자열

            int idx = bfMathch(s1, s2);
            if(idx == -1){
                System.out.println("텍스트에 패턴이 없습니다.");
            }else{
                //일치하는 문자 바로 앞까지의 길이를 구합니다.
                int len = 0;
                for(int i =0; i< idx; i++){
                    len += s1.substring(i,i+1).getBytes().length;
                }
                len+=s2.length();

                System.out.println((idx+1) +"번째 문자부터 일치합니다.");
                System.out.println("텍스트:"+s1);
                System.out.printf(String.format("패턴:%%%ds\n", len),s2);
            }
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
