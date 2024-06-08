import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
	    // 배열 입력
	    for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
	    // 비교하면서 출력
	    int n2 = sc.nextInt();
	    for(int i = 0; i < arr.length; i++) { 
	    	if ( arr[i] == n2 ) { 
	    		count ++;
	    	}
	    }
	    
	    //동일한 수 
	    System.out.println(count);
	}
}
