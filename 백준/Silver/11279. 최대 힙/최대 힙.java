import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while(N-- > 0){
             int num = Integer.parseInt(br.readLine());
             if(num == 0){
                 if(queue.isEmpty()) bw.write("0\n");
                 else bw.write(queue.poll() + "\n");
             } else if(num > 0){
                 queue.offer(num);
             }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
