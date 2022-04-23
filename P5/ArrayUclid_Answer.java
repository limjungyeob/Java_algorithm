package P5;

import java.util.Scanner;

public class ArrayUclid_Answer {
    static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return (x);
	}

	// 요솟수 n인 배열 a의 모든 요소의 최대 공약수를 구합니다.
	static int Arrgcd(int a[], int start, int no) {
		if (no == 1)
			return a[start];
		else if (no == 2)
			return gcd(a[start], a[start + 1]);
		else
			return gcd(a[start], Arrgcd(a, start + 1, no - 1));
	}
	// 2 4 6 8 
	// gcdArray(a[], 0, 4)
	// => gcd(2, gcdArray(a[], 1, 3))
	// => gcd(2, gcd(4, gcdArray(a[], 2, 2)))
	// => gcd(2, gcd(4, gcd(6, gcdArray(a[], 3, 1))))
	// => gcd(2, gcd(4, gcd(6, 8))
	// => gcd(2, gcd(4, 2))
	// => gcd(2, 2)
	// => 2
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        try {
            System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
		    int num;
		        do {
			        num = stdIn.nextInt();
		        } while (num <= 1);
            int x[] = new int[num];
            for(int i=0; i<x.length;i++){
                System.out.print("x["+i+"]=");
                x[i] = stdIn.nextInt();
            }

            System.out.println("최대공약수는"+Arrgcd(x,0,num)+"입니다.");
        } catch (Exception e) {
            
        }finally{
            stdIn.close();
        }
    }
}
