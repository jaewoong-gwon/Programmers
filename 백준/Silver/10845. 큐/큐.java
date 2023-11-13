import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            String command = input[0];
            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (!queue.isEmpty()) bw.write(queue.poll() + "\n");
                    else bw.write("-1\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (!queue.isEmpty()) bw.write("0\n");
                    else bw.write("1\n");
                    break;
                case "front":
                    if (!queue.isEmpty()) bw.write(queue.peek() + "\n");
                    else bw.write("-1\n");
                    break;
                case "back":
                    if (!queue.isEmpty()) bw.write(queue.peekLast() + "\n");
                    else bw.write("-1\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
