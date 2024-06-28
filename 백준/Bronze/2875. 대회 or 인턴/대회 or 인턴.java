import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int girl = Integer.parseInt(st.nextToken());
        int boy = Integer.parseInt(st.nextToken());
        int intern = Integer.parseInt(st.nextToken());

        // 일단 최대 팀 수를 계산
        int teams = Math.min(girl / 2, boy);

        // 인턴쉽에 참여해야 하는 인원을 고려하여 남는 인원 계산
        int remaining = girl + boy - (teams * 3);

        // 만약 인턴쉽에 참여해야 하는 인원이 남는 인원보다 많다면 팀 수를 줄여야 한다.
        while (intern > remaining) {
            teams--;
            remaining += 3; // 팀을 하나 줄이면 3명이 남는 인원에 추가됨
        }

        System.out.println(teams);
    }
}
