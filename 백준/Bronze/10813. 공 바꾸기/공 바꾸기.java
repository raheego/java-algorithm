
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //바구니의 개수 N과 공을 넣는 횟수 M 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 바구니의 상태를 저장할 배열 생성 및 초기화
        // 위에 입력값들을 바구니에 저장해야하니깐 for문으로 입력값들을 받는다.
        int[] baskets = new int[N]; // 바구니에 적혀있는 번호와 같은 번호가 적힌 공
        for(int i = 0; i < N; i ++ ){ // M줄에 걸쳐 공을 교환
            baskets[i] = i + 1; // 첫번째는 0 이지만 첫번째 바구니 이기때문에 1부터 시작이니 +1 해줌
        }

        // 비교, 공 교환하기
        for(int i = 0 ; i < M; i ++ ){
            int from = sc.nextInt() - 1; // 바구니번호는 1부터 시작하지만 인덱스 번호는 0부터 시작하기에 -1 해준다.
            int to = sc.nextInt() - 1;

            // 두 바구니의 공을 서로 교환
            int temp = baskets[from];
            baskets[from] = baskets[to];
            baskets[to] = temp;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}

