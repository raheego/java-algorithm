
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] cardLevel = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 레벨 입력 받기
        for(int i = 0; i < N; i++ ){
            cardLevel[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬
        Arrays.sort(cardLevel, Collections.reverseOrder());

        int gold = 0; // 골드 초기화

        // 가장 큰 레벨의 카드(cardLevel[0])와 다른 모든 카드를 합치면서 골드 계산
        for (int i = 1; i < N; i++) {
            gold += cardLevel[0] + cardLevel[i];
        }

        System.out.println(gold);
    }
}
