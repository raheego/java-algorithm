
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cardLevel = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++ ){
            cardLevel[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 큰 카드 레벨을 찾아야 하므로 오름차순 정렬
        Arrays.sort(cardLevel);

        int gold = 0; // 골드 초기화
        int maxLevel = cardLevel[N - 1]; // 가장 큰 카드 레벨

        // 나머지 모든 카드를 최대 레벨의 카드와 합친다
        for (int i = 0; i < N - 1; i++) {
            gold += maxLevel + cardLevel[i];
        }

        System.out.println(gold);
    }
}
