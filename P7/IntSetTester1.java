package P7;

public class IntSetTester1 {
    public static void main(String[] args) {
        IntSetPlus1 s1 = new IntSetPlus1(20);
        IntSetPlus1 s2 = new IntSetPlus1(20);
        IntSetPlus1 al = new IntSetPlus1(20);
        IntSetPlus1 rl = new IntSetPlus1(20);
        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println("s1은"+(s1.isEmpty()?"비었습니다.":"비어있지 않습니다."));

        al.add(10);
        al.addUnion(s1);
        rl.add(25);
        rl.add(14);
        rl.retainUnion(s2);
        
        System.out.println("al="+al);
        System.out.println("rl="+rl);
    }
}
