import java.util.*;
class Solution {
    static Map<Integer,String> data;
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        List<String> numbers = new ArrayList<>();
        data = new HashMap<>();
        
        char c = 'A';
        for(int i = 10; i <= 15; i++){
            data.put(i,String.valueOf(c++));
        }
        
        numbers.add("0");
        
        for(int i = 1; i < t*m; i++){
            numbers.add(cal(i,n));
        }
                
        // for(String str : numbers)System.out.println(str);        
        // while(answer.length() != t){
        //     if(idx >= t) break;
        //     String[] tmp = numbers.get(idx).split("");
        //     System.out.println(idx);
        //     for(int j = 0; j < tmp.length; j++){
        //         if(count == p){
        //             answer.append(tmp[j]);
        //             p += m;
        //         }
        //         count++;
        //     } 
        //     idx++;
        // }

        int count = 1;
        int idx = 0;

        loop : 
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i).length() != 1){
                String[] tmp = numbers.get(i).split("");
                for(int j = 0; j < tmp.length; j++){
                    if(count == p){
                        answer.append(tmp[j]);
                        p += m;
                        count++;
                        if(answer.length() == t) break loop;
                    } else count++;
                }
            } else {
                if(count == p){
                    answer.append(numbers.get(i));
                    p += m;
                    count++;
                    if(answer.length() == t) break loop;
                } else count++;

            }
      }

        
        return answer.toString();
    }

    static String cal(int number,int n){
        StringBuilder sb = new StringBuilder();
        while(number != 0){
            int tmp = number % n;
            if(tmp >= 10){
                sb.append(data.get(tmp));
            } else sb.append(tmp);
            number /= n;
        }
        sb.reverse();
        
        return sb.toString();
    }
}