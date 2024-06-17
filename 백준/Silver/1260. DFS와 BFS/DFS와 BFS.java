import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    static boolean[] visit;
    static LinkedList<Integer>[] graph;
    static int N; // 정점의 개수 N
    static int M; // 간선의 개수 M
    static int V; // 탐색을 시작할 정점의 번호 V

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visit = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 실행
        visit = new boolean[N + 1];
        bfs(V);
    }

    // 깊이 우선 탐색
    public static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");

        // 인접한 모든 미방문 노드
        for (int nextStart : graph[start]) {
            if (!visit[nextStart]) {
                dfs(nextStart);
            }
        }
    }

    // 너비 우선 탐색
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // 큐를 생성
        queue.add(start); // 시작 노드를 큐에 추가
        visit[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // 인접한 모든 미방문 노드를 큐에 추가
            for (int nextStart : graph[current]) {
                if (!visit[nextStart]) {
                    queue.add(nextStart);
                    visit[nextStart] = true;
                }
            }
        }
        System.out.println(); // BFS 결과 출력 후 개행
    }
}
