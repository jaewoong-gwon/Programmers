import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = reader.readLine().toCharArray();
        int start = 0;
        int end = arr.length - 1;
        boolean flag = false;


        while(start != end && start <= end){
            if(arr[start++] != arr[end--]){
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
