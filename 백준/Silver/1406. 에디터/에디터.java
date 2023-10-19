import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        char[] tmp = br.readLine().toCharArray();
        List<Character> editor = new LinkedList<>();
        for (char c : tmp) {
            editor.add(c);
        }
        ListIterator<Character> iterator = editor.listIterator();

        while(iterator.hasNext()) iterator.next();
        int loop = Integer.parseInt(br.readLine());

        for(int i = 0; i < loop; i++){
            char[] input = br.readLine().toCharArray();
            switch (input[0]){
                case 'L':
                    if(iterator.hasPrevious()) iterator.previous();
                    break;
                case 'D':
                    if(iterator.hasNext()) iterator.next();
                    break;
                case 'B':
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    iterator.add(input[2]);
                    break;
                default:
                    break;
            }
        }

        for(Character c : editor) bw.write(c);
        bw.flush();
        br.close();
    }
}
