import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int idx = 0;

        while(N-- > 0) arr[idx++] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int i : arr) bw.write(i + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
