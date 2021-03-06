package P8;

import java.util.Scanner;

//Boyer-Moore법으로 문자열을 검색
public class BMmatchPrint {
    static int bmMatch(String txt,String pat){
        int pt;     //txt커서
        int pp;     //pat커서
        int txtLen = txt.length();  //txt의 문자 개수
        int patLen = pat.length();  //pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE+1];    //건너뛰기 표
        int count = 0;  //비교 횟수
        int k = -1;

        //건너뛰기 표 만들기
        for(pt = 0; pt <= Character.MAX_VALUE;pt++){
            skip[pt] = patLen;
        }
        for(pt = 0; pt <patLen -1; pt++){
            skip[pat.charAt(pt)] = patLen - pt -1;  //pt == patLen -1
        }

        //검색
        while(pt < txtLen){
            pp = patLen -1;     //pat의 끝 문자에 주목
            if(k == pt-pp){
                System.out.print("    ");
            }else{
                System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
            }
            
            for(int i=0; i<txt.length();i++){
                System.out.print(txt.charAt(i)+" ");
            }
            System.out.println();

            for(int i=0; i<pt*2+4; i++){
                System.out.print(" ");
            }
            System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+':'|');
            System.out.println();

            for(int i=0; i<(pt-pp)*2+4; i++){
                System.out.print(" ");
            }
            for (int i = 0; i < pat.length(); i++){
				System.out.print(pat.charAt(i) + " ");
            }
            System.out.println();
            System.out.println();
            count++;

            while(txt.charAt(pt) == pat.charAt(pp)){
                if(pp == 0){
                    return pt;  //검색 성공
                }
                pp--;
                pt--;
                
                if(k == pt-pp){
                    System.out.print("    ");
                }else{
                    System.out.printf("%2d  ", pt - pp);
                    k = pt - pp;
                }
                
                for(int i=0; i<txt.length();i++){
                    System.out.print(txt.charAt(i)+" ");
                }
                System.out.println();
    
                for(int i=0; i<pt*2+4; i++){
                    System.out.print(" ");
                }
                System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+':'|');
                System.out.println();
    
                for(int i=0; i<(pt-pp)*2+4; i++){
                    System.out.print(" ");
                }
    
                System.out.println();
                System.out.println();
                count++;

                
            }
            System.out.printf("비교는 %d회입니다.\n", count);
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;      //검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        try {
            System.out.print("텍스트: ");
            String s1 = stdIn.next();   //텍스트용 문자열

            System.out.print("패턴: ");
            String s2 = stdIn.next();   //패턴용 문자열

            int idx = bmMatch(s1, s2);
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
