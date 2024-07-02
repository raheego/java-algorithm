import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 게임판의 크기
    static int [][] map; // 게임판의 값을 저장하는 2차원 배열
    static long [][] dp; // 경로의 개수를 저장하는 2차원 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 게임판의 크기 N을 입력받음
        N = Integer.parseInt(br.readLine());
        
        // 게임판과 경로의 개수를 저장할 배열 초기화
        map = new int[N][N];
        dp = new long[N][N];

        // 게임판의 각 칸의 값을 입력받음
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
           
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1; // 시작점 초기화
        
        // 동적 프로그래밍으로 경로의 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
              
                // 현재 칸에서 출발하는 경로가 있을 때만 계산
                if (dp[i][j] > 0) {
                    int val = map[i][j]; // 현재 칸의 값(점프 거리)
                    
                    // 점프 거리 val이 0보다 클 때만 오른쪽과 아래로 이동
                    if (val > 0) {
                        // 아래로 점프 (유효한 범위 내에 있을 때)
                        if (isValid(i + val)) dp[i + val][j] += dp[i][j];
                        
                        // 오른쪽으로 점프 (유효한 범위 내에 있을 때)
                        if (isValid(j + val)) dp[i][j + val] += dp[i][j];
                    }
                }
            }
        }
        
        // 가장 오른쪽 아래 칸에 도달할 수 있는 경로의 수 출력
        System.out.print(dp[N-1][N-1]);
    }
    
    // 유효한 인덱스 범위 확인 함수
    static boolean isValid(int val) {
        return val < N; // val이 게임판의 크기 N보다 작은지 확인
    }
}


