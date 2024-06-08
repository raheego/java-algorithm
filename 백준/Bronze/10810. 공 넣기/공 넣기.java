

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //바구니의 개수 N과 공을 넣는 횟수 M 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] baskets = new int[N]; // 바구니 상태를 저장하는 배열

        //각 방법은 세 정수 i j k로 이루어져 있으며, i번 바구니부터 j번 바구니까지에 k번 번호가 적혀져 있는 공을 넣는다는 뜻
        // start(i) 시작  end(j) 끝 ball(k) 공번호

        for(int i = 0; i < M; i ++ ){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ball = sc.nextInt(); //현재 반복에서 넣을 공의 번호

            // 시작 바구니부터 끝 바구니까지 공을 넣기
            for( int j = start -1; j <= end -1; j++){
                baskets[j] = ball; // 현재 반복 중인 바구니 범위에 해당하는 모든 바구니에 동일한 번호의 공을 넣는 역할
            }
        }

        // 바구니 상태 출력
        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }

        sc.close();



    }
}

