import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  //동전 종류 개수
        int K = Integer.parseInt(st.nextToken());  //가치의 합

        // 동전의 종류를 담은 인트 배열
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                count += (K / coins[i]);
                K = K % coins[i];
            }
        }
        System.out.print(count);
    }
}
