package chap02;

public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;        //곱셈과 나눗셈의 횟수
        int ptr = 0;            //찾은 소수의 개수
        int[] prime = new int[500];     //소수를 저장하는 배열

        prime[ptr++] = 2;       //ptr[0]에 2를 저장하고 ptr값을 1로 변경
        prime[ptr++] = 3;       //ptr[1]에 3을 저장하고 ptr값을 2로 변경

        for(int n=5; n<= 1000; n+=2){    //대상은 홀수만
            boolean flag =false;

            for(int i = 1; prime[i]*prime[i] <= n;i++){
                counter +=2;
                if(n%prime[i] ==0){ //나누어떨어지면 소수가 아님
                    flag = true;
                    break;
                }

            }
            if(!flag){
                prime[ptr++] = n;   //마지막까지 나누어 떨어지지 않음
                counter++;          //소수라고 배열에 저장
            }
        }
        for(int i=0;i<ptr;i++){
            System.out.println(prime[i]);
        }
        System.out.println("곱셈과 나눗셈을 수행한 횟수: "+counter);

    }
}
