import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        for(int i = 1; i <= 9; i++) {
            String[] arr = reader.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                int input = Integer.parseInt(arr[j-1]);
                if (max <= input) {
                    max = input;
                    x = i;
                    y = j;
                }

            }
        }

        writer.write(String.valueOf(max) + "\n" + x +" " + y);
        writer.flush();

        reader.close();
        writer.close();
    }
}
