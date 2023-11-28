import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.length() < o2.length()) return -1;
            else if(o1.length() > o2.length()) return 1;

            return o1.compareTo(o2);
        });

        while(N-- > 0){
            String str = br.readLine();
            if(!queue.contains(str)) queue.offer(str);
        }

        while(!queue.isEmpty()) bw.write(queue.poll() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
