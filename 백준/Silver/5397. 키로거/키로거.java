import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] array = br.readLine().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for(char c : array){
                switch (c){
                    case '<':
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }
            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < left.size(); k++) {
                sb.append(left.elementAt(k));
            }
            bw.write(sb.toString() + "\n");
        }
        br.close();
        bw.close();
    }
}