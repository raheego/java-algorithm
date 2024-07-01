import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 보도블록의 개수 N을 입력 받음
		char[] str = br.readLine().toCharArray(); // 보도블록의 문자열을 문자 배열로 변환하여 저장
		int[] dp = new int[n]; // DP 배열 선언 (각 위치까지의 최소 에너지 저장)
		
		int[] val = new int[n]; // 보도블록의 문자를 숫자로 매핑하기 위한 배열 선언
		for (int i = 0; i < n; i++) {
			if (str[i] == 'B') {
				val[i] = 0; // 'B'는 0으로 매핑
			} else if (str[i] == 'O') {
				val[i] = 1; // 'O'는 1로 매핑
			} else if (str[i] == 'J') {
				val[i] = 2; // 'J'는 2로 매핑
			}
		}

		Arrays.fill(dp, Integer.MAX_VALUE); // DP 배열을 초기화, 처음에는 최댓값으로 설정
		dp[0] = 0; // 첫 번째 보도블록은 에너지가 필요하지 않음 (시작점)

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// B, O, J 순서를 지켜야 하며, 이전 위치에서 도달 가능한 경우에만 최소 에너지 갱신
				if (val[j] != (val[i] + 2) % 3 || dp[j] == Integer.MAX_VALUE)
					continue;
				
				// dp[i]를 갱신할 때, 현재 위치 i까지의 최소 에너지를 계산함
				dp[i] = Math.min(dp[i], dp[j] + (int) Math.pow(i - j, 2));
			}
		}

		// 마지막 보도블록까지의 최소 에너지를 출력
		if (dp[n - 1] == Integer.MAX_VALUE) {
			bw.write(-1 + "\n"); // 도달할 수 없는 경우 -1 출력
		} else {
			bw.write(dp[n - 1] + "\n"); // 도달 가능한 경우 최소 에너지 출력
		}

		bw.flush(); // 출력 버퍼 비우기
	}

}
