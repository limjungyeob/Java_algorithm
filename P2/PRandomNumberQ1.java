package P2;

import java.util.Random;

public class PRandomNumberQ1 {
    static int maxOf(int[] a){
        int max=a[0];
        for(int i=0;i<a.length;i++){
            
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int PersonNum = rand.nextInt(10);

        int[] height = new int[PersonNum];
        System.out.println("사람수는 : "+PersonNum);
        for(int i=0; i<PersonNum;i++){
            height[i]= 100+rand.nextInt(90);
            System.out.println("height{" + i + "]:"+height[i]);
        }

        System.out.println("최댓값은"+maxOf(height)+"입니다.");
    }
}
