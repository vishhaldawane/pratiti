
public class MissingIntegerTest {
	public static void main(String[] args) {
		int A[]= {5,4,3,2,9,8,7,6};
		//int A[]= {5,3,2,1};
		long start = System.nanoTime();
		int val1 = 	Missing.solution1(A);
		long duration = (System.nanoTime() - start);
        System.out.println("Solution1 : "+duration  + "ns");

		start = System.nanoTime();
		int val2 = Missing.solution2(A);
		duration = (System.nanoTime() - start);
		System.out.println("Solution2 : "+duration + "ns");

		System.out.println("val1 "+val1);
		System.out.println("val2 "+val2);
		
	}
}

class Missing {

	static int solution1(int A[]) {
	    int N = A.length+1;        // 5
	    int total = N * (N+1) / 2 ;  // 15
	    int sum = 0;
	    for(int i : A) { 
	            total-=i; //15-2, 13-3, 10-1, 9-5
	    }
	    return total; // 4 
	}
    
	static int solution2(int A []) {
		int temp=0;
	    int counter=1;
	    for(int i : A) {
	            temp ^= i;
	            temp ^= counter;
	            counter++;
	    }
	    temp^= counter;
	    return temp;
	}
}