import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            char[] arr = br.readLine().toCharArray();
            for(char c : arr){
                switch (c){
                    case '<':
                        if(iterator.hasPrevious()) iterator.previous();
                        break;
                    case '>':
                        if(iterator.hasNext()) iterator.next();
                        break;
                    case '-':
                        if(iterator.hasPrevious()){
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default:
                        iterator.add(c);
                        break;
                }
            }
            for(Character ch : list) bw.write(ch);
            if(N >= 1) bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
