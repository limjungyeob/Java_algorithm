package chap04;

public class IntQueue {
    private int max;    //큐의 용량
    private int front;  //첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    //현재 데이터 수
    private int[] que;  //큐 본체

    //실행 시 예외 : 큐가 비어있음
    public class EmptyInQueueException extends RuntimeException{
        public EmptyInQueueException(){ }
    }
    //실행 시 예외: 큐가 가득참
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){ }
    }

    //생성자
    public IntQueue(int capacity){
        num = front = rear =0;
        max = capacity;
        try {
            que=new int[max];   //큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  //생성할 수 없음.
            max=0;
        }
    }

    //큐에 데이터를 인큐
    public int enqueue(int x) throws OverflowIntQueueException{
        if(num >= max)
            throw new OverflowIntQueueException();  //큐가 가득참
        que[rear++] = x;
        num++;
        if(rear ==max)  //rear값이 max와 같아질 경우 rear값을 0으로 초기화
            rear=0;
        return x;
    }

    //큐에서 데이터를 디큐
    public int deque() throws EmptyInQueueException{
        if(num<=0)
            throw new EmptyInQueueException();  //큐가 비어있음
        int x = que[front++];
        num--;
        if(front == max)
            front =0;   //front값이 max와 같아질 경우 frobt값을 0으로 초기화
        return x;
    }

    //큐에서 데이터를 피크(프론트 데이터를 들여다봄)
    public int peek() throws EmptyInQueueException{
        if(num<=0)
            throw new EmptyInQueueException();  //큐가 비어있음
        return que[front];
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x){
        for(int i=0;i<num;i++){
            int idx = (i+front)%max;    //모듈러 연산 아놔 이걸 이해못했네.
            if(que[idx] == x)   //검색 성공
                return idx;
        }
        return -1;  //검색 실패.
    }

    //큐를 비움.
    public void clear(){
        num=front=rear=0;
    }

    //큐의 용량을 반환
    public int capacity(){
        return max;
    }

    //큐에 쌓여 있는 데이터 수를 반환
    public int size(){
        return num;
    }

    //큐가 비어 있나요?
    public boolean isEmpty(){
        return num<=0;
    }

    //큐가 가득 찼나요?
    public boolean isFull(){
        return num>=max;
    }

    //큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump(){
        if(num <= 0){
            System.out.println("큐가 비어있습니다.");
        }else{
            for(int i=0;i<num;i++){
                System.out.print(que[(i+front)%max]+" ");
            }
            System.out.println();
        }    
    }
    public int search(int x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max;
            if(que[idx]==x){
                return i+1;
            }
        }
        return 0;
    }
}
