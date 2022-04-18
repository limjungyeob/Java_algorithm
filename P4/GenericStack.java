package P4;

public class GenericStack<T> {
    private int max;    //스택 용량
    private int ptr;    //스택 포인터
    private T[] stk;  //스택 본체

    // 실행 시 예외: 스택이 비어 있음
    public static class EmptyGenericStackException extends RuntimeException{
        public EmptyGenericStackException(){
        }
    }

    // 실행 시 예외: 스택이 가득참
    public static class OverflowGenericStackException extends RuntimeException{
        public OverflowGenericStackException(){
        }
    }

    //생성자
    @SuppressWarnings("unchecked")
    public GenericStack(int capacity){
        ptr = 0;        //생성 시 스택은 비어 있으므로 스택 포인터 ptr값을 0으로 한다.
        max = capacity;
        try{
            stk = (T[]) new Object[max]; // 스택 본체용 배열을 생성
           
        }catch(OutOfMemoryError e){  //생성할 수 없음
            max=0;
        }
    }

    //스택에 x를 푸쉬
    public T push(T x) throws OverflowGenericStackException{
        if(ptr>=max)        //스택이 가득참
            throw new OverflowGenericStackException();
        return stk[ptr++] = x;
    }

    //스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public T pop() throws EmptyGenericStackException{
        if(ptr <= 0) //스택이 비어 있음
            throw new EmptyGenericStackException();
        return stk[--ptr];
    }

    //스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public T peek() throws EmptyGenericStackException{
        if(ptr <= 0)    //스택이 비어 있음
            throw new EmptyGenericStackException();
        return stk[ptr-1];
    }

    //스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(T x){
        for(int i=ptr-1;i>=0;i--){   //정상쪽에서 선형검색
            if(stk[i].equals(x)){
                return i; //검색성공  
            }
        }
         return -1;  //검색실패
    }

    //스택을 비움
    public void clear(){
        ptr = 0;
    }

    //스택의 용량을 반환
    public int capacity(){
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size(){
        return ptr;
    }

    //스택이 비어 있는가?
    public boolean isEmpty(){
        return ptr<=0;
    }

    //스택이 가득 찼는가?
    public boolean isFull(){
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(){
        if(ptr <= 0){
            System.out.println("스택이 비어 있습니다.");
        }else{
            for(int i=0; i < ptr;i++)
                System.out.print(stk[i]+"");
            System.out.println();
        }
    }
}

