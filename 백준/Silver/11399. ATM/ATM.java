import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫번째 사람 수
        int[] time = new int[N]; // 사람 수만큼 시간을 담을 배열 구성

        // 인출 시간 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken()); // 계속 입력을 받기 위해 nextToken을 해줘야함
        }

        // 걸리는 인출시간을 최소 단위로 정렬하고 (낮은순)
        Arrays.sort(time);

        int sum = 0; // 각 사람이 인출하는데 걸리는 시간
        int total = 0; // 시간의 합

        // 각 사람들이 기다린 시간
        for (int i = 0; i < N; i++) {
            sum += time[i];
            total += sum;
        }

        System.out.println(total);
    }
}
