import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1); // 초기값으로 -1을 채워놓습니다.

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            int minGreaterValue = Integer.MAX_VALUE; // 최소값을 저장할 변수, 일단 최대값으로 초기화합니다.

            for (int j = s; j <= e; j++) {
                if (arr[j] > k && arr[j] < minGreaterValue) {
                    minGreaterValue = arr[j];
                }
            }

            if (minGreaterValue != Integer.MAX_VALUE) {
                answer[i] = minGreaterValue;
            }
        }

        return answer;
    }

}
//https://megak.tistory.com/153