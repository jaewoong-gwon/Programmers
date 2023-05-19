import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
       
        Queue<Character> queue = new LinkedList<>();
        
        char[] skill_charArray = skill.toCharArray();
        
        for(int i = 0; i < skill_trees.length; i++){
            char[] charArray = skill_trees[i].toCharArray();
            for(int j = 0; j < charArray.length; j++){
                char c = charArray[j];
                for(int k = 0; k < skill_charArray.length; k++){
                    if(c == skill_charArray[k]) queue.add(c);
                }
            }
            
            int index = 0;
            boolean flag = false;
            while( queue.size() != 0){
               char c = queue.poll();
               if(skill_charArray[index++] != c){
                   flag = true;
                   break;
               }
                
            }
            if(queue.size() != 0) queue.clear();
            
            if(!flag) answer++;
         }
        return answer;
    }
} 