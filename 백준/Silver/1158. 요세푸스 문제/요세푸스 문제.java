import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) list.add(i);
		
		bw.write("<");
		int index = 0; 
		while(!list.isEmpty()) {
			index = (index + K -1) % list.size();
			int tmp = list.remove(index);
			if(list.size() >= 1) bw.write(tmp + ", ");
			else bw.write(String.valueOf(tmp));
		}
		
		bw.write(">");
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}

