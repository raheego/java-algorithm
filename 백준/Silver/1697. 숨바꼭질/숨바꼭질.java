import java.util.*;
import java.io.*;
 
public class Main {
    static int n, m;
    static int[] visited = new int[100001];
    static int[] move = {-1, 1, 2};
    static Queue<Integer> Q = new LinkedList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
       
        if (n == m) System.out.println(0); // 시작점 도착점이 같을 경우
        else bfs(n);
    }
 
    public static void bfs(int v) {
        visited[v] = 1; // 시작 위치 방문 처리
        Q.offer(v);
        
        while (!Q.isEmpty()) {
            int size = Q.size();  // 현재 큐의 크기
        
            for (int x = 0; x < size; x++) {
                int target = Q.poll();
        
                for (int i = 0; i < 3; i++) {
                    int nv;
					        
						        // i가 2인 경우, 즉 순간이동인 경우
                    if (i == 2) nv = target * move[i];
                    else nv = target + move[i];  // 걷는 경우
        
						        // 새로운 위치가 동생의 위치와 같다면, 현재까지의 시간 출력 후 종료
                    if (nv == m) {
                        System.out.print(visited[target]);
                        return;
                    }
        
						        // 새로운 위치가 유효한 범위 내에 있고 아직 방문하지 않은 경우
                    if (nv >= 0 && nv < 100001 && visited[nv] == 0) {
                        Q.offer(nv);
                        
                         // 새로운 위치 방문 처리, 현재 위치의 시간 + 1
                        visited[nv] = visited[target] + 1;
                    }
                }
            }
        }
    }
}