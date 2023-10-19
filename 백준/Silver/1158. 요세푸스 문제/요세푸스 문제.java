import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        for(int i = 1; i <= N; i++) queue.offer(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int num = 0;
        while(!queue.isEmpty()){
            num++;
            if(num % K == 0){
                int number = queue.poll();
                if(queue.size() == 0) sb.append(number);
                else sb.append(number).append(", ");
            }
            else queue.offer(queue.poll());
        }
        sb.append(">");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
