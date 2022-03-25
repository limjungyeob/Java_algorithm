package chap02;
public class CloneArray{
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        int[] b= a.clone();

        b[3] = 0;

        System.out.print("a=");

        for(int i=0; i< a.length;i++){
            System.out.print(" "+a[i]);
        }
System.out.printf("\nb=");
        for(int i=0; i< b.length;i++){
            System.out.print(" "+a[i]);
        }
    }
}