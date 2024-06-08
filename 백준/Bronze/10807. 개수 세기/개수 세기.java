import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫째 줄에 정수의 개수 N 입력
        int n = sc.nextInt();

        // 둘째 줄에 N개의 정수 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 셋째 줄에 찾으려고 하는 정수 v 입력
        int v = sc.nextInt();

        // v가 몇 개인지 세기 위한 변수 count
        int count = 0;

        // 배열을 순회하며 v의 개수 세기
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == v) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);

        // Scanner 닫기
        sc.close();
    }
}
