package P4;

public class DeckIntQueue {
    private int max;    //덱의 용량
    private int front;  //첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    //현재 데이터 수
    private int[] que;  //덱의 본체

    //실행 시 예외 : 큐가 비어있음
    public class EmptyDeckIntQueueException extends RuntimeException{
        public EmptyDeckIntQueueException(){ }
    }
    //실행 시 예외: 큐가 가득참
    public class OverflowDeckIntQueueException extends RuntimeException{
        public OverflowDeckIntQueueException(){ }
    }

    //생성자
    public DeckIntQueue(int capacity){
        num = front = rear =0;
        max = capacity;
        try {
            que=new int[max];   //큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  //생성할 수 없음.
            max=0;
        }
    }

    //덱에 데이터를 머리쪽부터 인큐
    public int Frontenqueue(int x) throws OverflowDeckIntQueueException{
        if(num >= max)
            throw new OverflowDeckIntQueueException();  //덱이 가득참
        num++;
        if(--front<0){
            front=max-1;
        }
        que[front]=x;
        return x;
    }
    //덱에 데이터를 꼬리쪽부터 인큐
    public int Rearenqueue(int x) throws OverflowDeckIntQueueException{
        if(num>=max){
            throw new OverflowDeckIntQueueException();  //덱이 가득참
        }
        que[rear++] = x;
        num++;
        if(rear == max){
            rear=0;
        }
        return x;
    }

    //덱의 머리부터 데이터를 디큐
    public int Frontdeque() throws EmptyDeckIntQueueException{
        if(num<=0)
            throw new EmptyDeckIntQueueException();  //덱가 비어있음
        int x = que[front++];
        num--;
        if(front == max)
            front =0;   //front값이 max와 같아질 경우 frobt값을 0으로 초기화
        return x;
    }

    //덱의 꼬리부터 데이터를 디큐
    public int Reardeque() throws EmptyDeckIntQueueException{
        if(num<=0)
            throw new EmptyDeckIntQueueException(); //덱이 비어있음
        num--;
        if(--rear<0){
                rear = max-1;
        }
        return que[rear];
    }



    //덱의 머리부터 데이터를 피크(머리 데이터를 들여다봄)
    public int Frontpeek() throws EmptyDeckIntQueueException{
        if(num<=0)
            throw new EmptyDeckIntQueueException();  //큐가 비어있음
        return que[front];
    }

    //덱의 꼬리부터 데이터를 피크(꼬리데이터를 살펴봄)
    public int Rearpeek() throws EmptyDeckIntQueueException{
        if(num<=0)
            throw new EmptyDeckIntQueueException();  //덱이 비어있음
        return que[rear==0?max-1:rear-1];

    }
    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x){
        for(int i=0;i<num;i++){
            if(que[(i+front)%max] == x)   //검색 성공
                return i+front;
        }
        return -1;  //검색 실패.
    }
    public int search(int x) {
		for (int i = 0; i < num; i++){
			if (que[(i + front) % max] == x) {  // 검색성공
				return i + 1;
            }
        }
		return 0; // 검색실패
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
   
}
