package chap06;
//신체 검사 데이터 배열을 정렬합니다. 

import java.util.Arrays;
import java.util.Comparator;


public class PhyscExamSort {
    //신체검사 데이터
    static class physcData{
        String name;    //이름
        int height;     //키
        double vision;  //시력

        //생성자
        physcData(String name, int height,double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        //신체검사 데이터를 문자열로 반환합니다.
        public String toString(){
            return name+" "+height+" "+vision;
        }

        //키 오름차순용 comparator
        static final Comparator<physcData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<physcData>{
            public int compare(physcData d1, physcData d2){
                return (d1.height > d2.height)? 1: (d1.height < d2.height)? -1 : 0;
            }
        }

    }
    public static void main(String[] args) {
      

        physcData[] x = {
            new physcData("이나령", 162, 0.3),
            new physcData("진서현", 173, 0.7),
            new physcData("이수민", 175, 2.0),
            new physcData("홍준기", 171, 1.5),
            new physcData("유지훈", 168, 0.4),
            new physcData("이호연", 174, 1.2),
            new physcData("김한결", 169, 0.8),
        };
        Arrays.sort(x,  //배열 x를
        physcData.HEIGHT_ORDER);        //HEIGHT_ORDER을 사용하여 정렬
        System.out.println("신체검사 리스트");
        System.out.println("이름        키  시력");
        System.out.println("-------------------");
        for(int i=0;i<x.length;i++){
            System.out.printf("%-8s%3d%5.1f\n",x[i].name,x[i].height,x[i].vision);
        }
    }
}
