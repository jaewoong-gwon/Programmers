import java.util.*;
class Solution {
    static Map<String,Integer> names;
    static Map<Integer,String> scores;
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        names = new HashMap<>();
        scores = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            names.put(players[i],i+1);
            scores.put(i+1,players[i]);
        }
        
        for(int i = 0; i < callings.length; i++){
            String name = callings[i];
            change(name);
        }
        
        for(int i = 1; i <= players.length; i++){
            answer[i-1] = scores.get(i);
        }
        
        return answer;
    }
    
    static void change(String name){
        // 추월한 선수의 현재 등수
        int score = names.get(name);
        // 추월 당하는 선수의 이름
        String n = scores.get(score -1);

        names.replace(name,score -1);
        names.replace(n,score);
        
        scores.replace(score,n);
        scores.replace(score -1,name);
    }
}