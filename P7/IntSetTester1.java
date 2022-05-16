package P7;

public class IntSetTester1 {
    public static void main(String[] args) {
        IntSetPlus1 s1 = new IntSetPlus1(20);
        IntSetPlus1 s2 = new IntSetPlus1(20);
        IntSetPlus1 al = new IntSetPlus1(20);
        IntSetPlus1 rl = new IntSetPlus1(20);
        IntSetPlus1 dl = new IntSetPlus1(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        //s1(10,15,20,25)
        //s2(10,15,20,25,12)
        System.out.println("s1"+s1);
        System.out.println("s2"+s2);
        System.out.println("합집합 테스트");
        al.add(1);
        al.addUnion(s1);
        System.out.println(al);
        System.out.println("교집합 테스트");
        rl.add(15);
        rl.add(32);
        System.out.println(rl);
        rl.retainUnion(s1);
        System.out.println(rl);

        System.out.println("차집합 테스트");
        dl.copyFrom(s2);
        System.out.println(dl);
        dl.removeUnion(s1);
        System.out.println(dl);
    }
}
