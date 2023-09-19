import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = reader.readLine().toCharArray();
        int idx = arr.length - 1;
        boolean flag = false;
        for(int i = 0; i < arr.length / 2; i++){
            if(arr[i] != arr[idx--]) {
                flag = true;
                break;
            }
        }
        if(flag) writer.write("0");
        else writer.write("1");

        writer.flush();

        reader.close();
        writer.close();
    }
}
