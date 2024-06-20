import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];  // 인접 행렬을 사용하여 그래프를 표현
    static boolean node[];  // 방문 여부를 확인하는 배열
    static int N, M, count;  // 정점의 개수와 연결 요소의 개수를 저장하는 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // 첫 줄을 읽어와서 정점의 개수(N)와 간선의 개수(M)를 파싱
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
				M = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        // 그래프를 인접 행렬로 초기화
        // 인덱스가 0부터니 +1을 해줌 (정점이 1부터이니깐)
        arr = new int[N + 1][N + 1];
        node = new boolean[N + 1];  // 방문 여부를 초기화
        
        // 간선 정보를 읽어와서 인접 행렬에 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 양쪽 모두 1로 설정
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        
        count = 0;  // 연결 요소의 개수를 초기화
        
        //DFS
        for (int i = 1; i <= N; i++) {
            // 아직 방문하지 않은 정점을 찾음
            if (!node[i]) {
                DFS(i);  // DFS를 통해 연결된 모든 정점을 방문
                count++;  // 새로운 연결 요소를 찾았으므로 개수를 증가
            }
        }
        
        // 최종적으로 연결 요소의 개수를 출력
        System.out.println(count);
    } // End of main
    
    // DFS를 이용한 그래프 탐색
    static void DFS(int value) {
        // 이미 방문한 정점이면 종료
        if (node[value]) {
            return;
        }

        node[value] = true;  // 현재 정점을 방문으로 표시
        // 현재 정점과 연결된 다른 정점을 탐색
			 	for(int i=1; i<=N; i++) {
					if(arr[value][i] == 1) {
					DFS(i);
			}
		}
	}

} // End of class