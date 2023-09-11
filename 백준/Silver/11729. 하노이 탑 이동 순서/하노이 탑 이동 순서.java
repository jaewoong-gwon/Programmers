import java.io.*;

public class Main {
    static BufferedWriter writer;
    static StringBuilder sb;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        count = 0;
        int from = 1;
        int to = 3;
        int aux = 2;
        hanoi(n,from,to,aux);

        writer.write(count + "\n" + sb.toString());
        writer.flush();
    }

    static void hanoi(int n, int from, int to, int aux) throws IOException {
        count++;
        if(n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(n-1,from,aux,to);
        sb.append(from + " " + to + "\n");
        hanoi(n-1,aux,to,from);
    }
}
