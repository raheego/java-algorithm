

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int max = 0;

        for (int i = 0; i < N; i ++ ){
            tree[i] = Integer.parseInt(st.nextToken());

            //나무들 중 최댓값을 구하기 위해 매 입력 때마다 max 변수와 비교하여
            // 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신해준다.
            if(max < tree[i]) {
                max = tree[i];
            }
        }

        int left = 0;
        int right = max;

        // 이분탐색
        while (left < right) {
           int mid = (left + right) / 2;
           long sum = 0;

            for( int treeHeight : tree){

                //tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
                // 음수의 경우 x , 양수만 더하기
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }


            if ( sum < M ){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }

}

