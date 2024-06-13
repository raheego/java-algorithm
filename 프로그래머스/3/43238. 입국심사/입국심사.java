import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // times 배열을 오름차순으로 정렬합니다.
        Arrays.sort(times);
        
        // 이진 탐색 범위 초기화
        long min = 1;
        long max = (long) times[times.length-1] * n;
        long mid = 0;
        long sum;
        long answer = max;

        // 이진 탐색 수행
        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;

            // 각 심사관의 심사 시간을 순회하며 현재 중간 시간 내에 심사할 수 있는 총 사람 수 계산
            for (int time : times) {
                sum += mid / time;
            }

            // 모든 사람이 심사를 받을 수 있는지 확인
            if (sum >= n) {
                answer = mid;  // 가능한 경우, 최소 시간을 갱신
                max = mid - 1; // 시간을 줄이기 위해 max 값을 줄임
            } else {
                min = mid + 1; // 불가능한 경우, 시간을 늘리기 위해 min 값을 늘림
            }
        }

        // 최적의 시간 반환
        return answer;
    }
}
