
import java.util.Scanner;
import java.util.Stack;


public class Main {

    // 정수형 stack 사용하기 위함
    public static int[] stack;

    // 이 변수는 현재 스택에 저장된 요소의 개수를 추적하는 역할, 처음 스택은 비어있기에 초기값 0 설정
    public static int size = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int N = sc.nextInt();
        stack = new int[N]; // stack 정수형 배열, 스택을 저장할 공간

        for(int i = 0; i < N; i++ ){

            String str = sc.next();

            switch ( str ){

                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }


    private static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop(){
        if(size == 0) {
            return -1;
        } else{
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size --;

            return res;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0){
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0){
            return -1;
        } else {
            return stack[size -1];
        }
    }
}


