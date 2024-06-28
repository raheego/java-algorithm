
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");
        Arrays.sort(N, Collections.reverseOrder());

        int sum = 0;
        boolean hasZero = false;

        // 각 숫자의 합을 구하고 0이 있는지 확인
        for (String numStr : N) {
            int num = Integer.parseInt(numStr);
            sum += num;
            
            if (num == 0) {  
                hasZero = true;
            }
        }
		
				// 30배수
        if (hasZero && sum % 3 == 0) {
            System.out.println(String.join("", N));
        } else {
            System.out.println("-1");
        }
    }
}
