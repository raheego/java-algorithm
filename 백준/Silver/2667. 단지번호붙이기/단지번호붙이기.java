import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] danji;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; //상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> result; // 각 단지의 집의 수를 저장하는 리스트
    static int cnt, N;     // 현재 단지의 집의 수를 세는 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 결과를 저장할 리스트 초기화
        result = new LinkedList<>(); 
        N = Integer.parseInt(br.readLine()); // 지도의 크기 N 입력받기
        
        // 단지 배열과 방문 여부 배열 초기화
        danji = new int[N][N];
        visited = new boolean[N][N];
        // 단지 내 집의 수 초기화 (첫 번째 집을 포함하기 위해 1로 설정)
        cnt = 1;
        
        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                danji[i][j] = str.charAt(j) - '0';
            }
        }
        
        // 지도 전체를 순회하면서 DFS로 단지 찾기
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 집이 있고 방문하지 않은 경우 새로운 단지 시작
                if (danji[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);  
                    result.add(cnt);  // 단지 크기 추가
                    cnt = 1;  // 다음 단지를 위해 집의 수 초기화
                }
            }
        }
        
        // 단지 내 집의 수를 오름차순으로 정렬
        Collections.sort(result);
        
        // 결과 출력
        bw.write(result.size() + "\n");  // 단지 수 출력
        for (int r : result) {
            bw.write(r + "\n");  // 각 단지의 집의 수 출력
        }
        bw.flush();
        bw.close();
    }
    
    // DFS를 통해 단지 내 모든 집을 방문하고 집의 수를 세는 함수
    public static void dfs(int x, int y) {
        // 현재 위치 방문 처리
        visited[x][y] = true;
        
        // 상하좌우로 이동하며 탐색
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            // 이동한 위치가 범위 내에 있고, 방문하지 않았으며, 집이 있는 경우
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && danji[nx][ny] == 1) {
                cnt++;  // 집의 수 증가
                dfs(nx, ny);  // 재귀적으로 DFS 호출
            }
        }
    }
}
