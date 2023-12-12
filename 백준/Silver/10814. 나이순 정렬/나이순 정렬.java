import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<User> list = new ArrayList<>();
        while(N-- > 0){
            String[] input = br.readLine().split(" ");
            list.add(new User(Integer.parseInt(input[0]),input[1]));
        }

        list.sort((u1, u2) -> {
            if (u1.getAge() < u2.getAge()) return -1;
            else if (u1.getAge() > u2.getAge()) return 1;
            return 0;
        });

        for (User user : list) {
            bw.write(user.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class User {
        private int age;
        private String name;
        User(){};
        User(int age, String name){
            this.age = age;
            this.name = name;
        }
        int getAge() { return this.age; }
        String getName() { return this.name; }
        @Override
        public String toString(){
            return this.age + " " + this.name;
        }
    }
}
