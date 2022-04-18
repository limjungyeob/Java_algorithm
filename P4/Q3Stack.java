package P4;

public class Q3Stack {
    private int max;    //스택 용량
    private int ptrA;    //스택 포인터A
    private int ptrB;   //스택 포인터 B
    private int[] stk;  //스택 본체

    // 실행 시 예외: 스택이 비어 있음
    public class EmptyQ3StackException extends RuntimeException{
        public EmptyQ3StackException(){
        }
    }

    // 실행 시 예외: 스택이 가득참
    public class OverflowQ3StackException extends RuntimeException{
        public OverflowQ3StackException(){
        }
    }

    //생성자
    public Q3Stack(int capacity){
        
        max = capacity;
        ptrA=0; //A스택 포인터 초기화
        ptrB=max-1; //B스택 포인터 초기화
        try{
            stk = new int[max];     //스택 본체용 배열을 생성
        }catch(OutOfMemoryError e){  //생성할 수 없음
            max=0;
        }
    }

    //스택A에 x를 푸쉬
    public int pushA(int x) throws OverflowQ3StackException{
        if(ptrA>ptrB)        //스택이 가득참
            throw new OverflowQ3StackException();
        return stk[ptrA++] = x;
    }
    //스택 B에 x를 푸쉬
    public int pushB(int x) throws OverflowQ3StackException{
        if(ptrB<ptrA)  //스택이 가득참
            throw new OverflowQ3StackException();
        return stk[ptrB--] = x;
    }

    //A스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public int popA() throws EmptyQ3StackException{
        if(ptrA <= 0) //스택이 비어 있음
            throw new EmptyQ3StackException();
        return stk[--ptrA];
    }
    //B스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public int popB() throws EmptyQ3StackException{
        if(ptrB<max/2)
            throw new EmptyQ3StackException();
        return stk[++ptrB];
    }

    //A스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public int peekA() throws EmptyQ3StackException{
        if(ptrA <= 0)    //스택이 비어 있음
            throw new EmptyQ3StackException();
        return stk[ptrA-1];
    }

    //B스택에서 데이터를 피크 (정상에 있는 데이터를 들여다봄)
    public int peekB() throws EmptyQ3StackException{
        if(ptrB == max-1)//스택이 비어있음
            throw new EmptyQ3StackException();
        return stk[ptrB+1];
    }

    //스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOfA(int x){
        for(int i=ptrA-1;i>=0;i--){   //정상쪽에서 선형검색
            if(stk[i] == x){
                return i; //검색성공  
            }
        }
         return -1;  //검색실패
    }
    public int indexOfB(int x){
        for(int i=ptrB+1;i<=max-1;i++){ //정상쪽에서 선형검색
            if(stk[i] == x){
                return i;
            }
        }
        return -1;
    }

    //스택을 비움
    public void clear(){
        ptrA = 0;
        ptrB = max-1;
    }

    //스택의 용량을 반환
    public int capacity(){
        return max/2;
    }

    //스택에 쌓여 있는 A데이터 수를 반환
    public int sizeA(){
        return ptrA;
    }

    //스택에 쌓여 있는 B데이터 수를 반환
    public int sizeB(){
        return max-ptrB-1;
    }
    //스택이 비어 있는가?
    public boolean isEmptyA(){
        return ptrA<=0;
    }

    public boolean isEmptyB(){
        return ptrB==max-1;
    }

    //스택이 가득 찼는가?
    public boolean isFullA(){
        return ptrA >= max-1/2;
    }
    public boolean isFullB(){
        return ptrB <= max-1/2;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dumpA(){
        if(ptrA <= 0){
            System.out.println("스택이 비어 있습니다.");
        }else{
            for(int i=0; i < ptrA;i++)
                System.out.print(stk[i]+"");
            System.out.println();
        }
    }
    public void dumpB(){
        if(ptrB == max-1){
            System.out.println("스택이 비어 있습니다.");
        }else{
            for(int i=ptrB+1; i<max;i++)
                System.out.print(stk[i]+"");
            System.out.println();
        }
    }
}

