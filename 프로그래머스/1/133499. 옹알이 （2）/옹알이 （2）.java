import java.util.*;
class Solution {
    static Set<String> set;
    public int solution(String[] babbling) {
        int answer = 0;
        String[] alpha = new String[]{"aya","ye","woo","ma"};
        set = new HashSet<>();
        int max = Arrays.stream(babbling).mapToInt(String::length).max().getAsInt();

        dfs(alpha,"",max);
        for(String b : babbling){
            if(set.contains(b)) answer++;
        }
        return answer;
    }
    static void dfs(String[] alpha, String current, int n){
        if(set.contains(current)) return;
        
        set.add(current);
        if(current.length() > n) return;
        for(String a : alpha){
            if(set.contains(current + a)) continue;
            if(current.length() - a.length() >= 0){
                if(current.substring(current.length() - a.length(), current.length()).equals(a)) continue;
            }
            
            dfs(alpha,current + a, n);
        }
    }
}