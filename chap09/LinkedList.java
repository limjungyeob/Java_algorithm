package chap09;

import java.util.Comparator;

// 연결 리스트 클래스
public class LinkedList<V> {
    //노드
    class Node<V>{
        private V data;     //데이터(데이터를 가리킵니다.)
        private Node<V> next;   //뒤쪽포인터(다음 노드 참조)

        Node(V data, Node<V> next){
            this.data = data;
            this.next = next;
        }

    }
    private Node<V> head;       //머리 노드
    private Node<V> crnt;       //선택 노드

    //생성자
    public LinkedList(){
        head = crnt = null;
    }

    //노드검색
    public V search(V obj, Comparator<?super V> c){
        Node<V> ptr = head;     //현재 스캔 중인 노드

        while(ptr != null){
            if(c.compare(obj, ptr.data) == 0){  //검색 성공
                crnt =ptr;
                return ptr.data;
            }
            ptr = ptr.next;     //다음 노드를 선택
        }
        return null;
    }

    //머리에 노드 삽입
    public void addFirst(V obj){
        Node<V> ptr = head;     //삽입 전의 머리 노드
        head = crnt = new Node<V>(obj,ptr);
    }

    //꼬리에 노드 삽입
    public void addLast(V obj){
        if(head == null){       //리스트가 비어 있으면
            addFirst(obj);      //머리에 삽입
        }else{
            Node<V> ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<V>(obj,null);
        }
    }

    //머리 노드를 삭제
    public void removeFirst(){
        if(head != null){   //리스트가 비어 있지 않으면
            head = crnt = head.next;
        }
    }

    //꼬리 노드를 삭제
    public void removeLast(){
        if(head != null){
            if(head.next == null){  //노드가 하나만 있으면
                removeFirst();      //머리 노드를 삭제
            }else{
                Node<V> ptr = head; //스캔 중인 노드
                Node<V> pre = head; //머리 노드를 삭제

                while(ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }

                pre.next = null;    //pre는 삭제 후의 꼬리누드
                crnt = pre;
            }
        }
    }

    //노드 p를 삭제
    public void remove(Node p){
        if(head != null){
            if(p == head){
                removeFirst();
            }else{
                Node<V> ptr = head;

                while(ptr.next != p){
                    ptr = ptr.next;
                    if(ptr == null) return; //p가 리스트에 없습니다.
                }

                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    //선택 노드를 삭제
    public void removeCurrentNode(){
        remove(crnt);
    }

    //모든 노드를 삭제
    public void clear(){
        while(head != null){    //노드에 아무것도 없을 때까지
            removeFirst();      //머리 노드를 삭제
        }
        crnt = null;
    }

    //선택 노드를 하나 뒤쪽으로 이동
    public boolean next(){
        if(crnt == null || crnt.next == null){
            return false;       //이동할수없음.
        }
        crnt = crnt.next;
        return true;
    }

    //선택 노드를 출력
    public void printCurrentNode(){
        if(crnt == null){
            System.out.println("선택한 노드가 없습니다.");
        }else{
            System.out.println(crnt.data);
        }
    }

    //모든 노드를 출력
    public void dump(){
        Node<V> ptr = head;

        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
