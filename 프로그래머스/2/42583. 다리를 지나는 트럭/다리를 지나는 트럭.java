import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<>();
        int sum = 0; // 다리 위 트럭들의 무게 합
        
        for (int truck : truck_weights) {
            while (true) {
                // 다리에 트럭이 없는 경우
                if (que.isEmpty()) {
                    que.add(truck);
                    sum += truck;
                    answer++;
                    break;
                } 
                // 다리에 트럭이 꽉 찬 경우
                else if (que.size() == bridge_length) {
                    sum -= que.poll();
                } 
                else {
                    // 다리에 트럭을 실을 수 있을 경우
                    if (sum + truck <= weight) {
                        que.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    } 
                    // 다리에 트럭 무게가 초과인 경우
                    else {
                        que.add(0);
                        answer++;
                    }
                }
            }
        }
        
        // 마지막 트럭이 빠져나오는 시간
        answer += bridge_length;
        
        return answer;
    }
}
