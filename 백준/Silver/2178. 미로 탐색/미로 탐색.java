

import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};  // x 방향 상하좌우
    static int[] dy = {0, 0, -1, 1}; // y방향 상하좌우
    static int N, M , count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true; // 시작위치 방문표시

        for(int i=0; i < N; i++) {
            String s = br.readLine();

            for(int j=0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        // 시작위치 넣어주기
        bfs(0, 0);

        // bfs 를 거치고 나면 도착할 칸의 행렬의 값은 거쳐야 할 최소 칸의 수가 되므로
        System.out.println(map[N - 1][M - 1]);  // 마지막 칸의 인덱스로 값을 출력해주기.
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Point currentPoint = q.poll();

            // 현재 위치에서 사방위 이동가능여부 판별해주기
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                // 1. 범위 이내에 있는가?
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;   // 범위에서 나가면 제끼기
                // 2. 막힌 길인가?
                if (map[nextX][nextY] == 0)
                    continue;   // 막힌 길이면 제끼기
                // 3. 이미 방문 했나?
                if (visited[nextX][nextY])
                    continue;   // 방문했으면(true 이면) 제끼기
                // 모든 조건에 해당되지 않음. 즉, 갈 수 있는 길 이면
                // queue 에 삽입해주고 방문처리.
                q.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                // 그리고 최소 칸의 수를 구해야되므로 해당하는 칸에 1씩 누적해서
                // 도착 칸이면 그 값이 지나야 하는 최소 칸의 수.
                map[nextX][nextY] = map[currentPoint.x][currentPoint.y] + 1;
            }
        }

    }
}
