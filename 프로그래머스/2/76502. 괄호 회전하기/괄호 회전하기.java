import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] charArray = s.toCharArray();
        
        if(charArray.length % 2 == 1) return answer;
        
        
        List<Character> list = new ArrayList<>();
        
        for(char c : charArray) list.add(c);
        
        Stack<Character> stack = new Stack<>();
        
        int loop = 0;
        while(loop != list.size()){
            int count = 0;
            for(char c : list){
                if(stack.size() >= 1){
                    char tmp = stack.peek();
                    // System.out.println(loop + " : " + tmp);
                    if(tmp == '(' && c == ')' ||
                       tmp == '{' && c == '}' ||
                       tmp == '[' && c == ']'){
                        count++;
                        stack.pop();
                    } else stack.push(c);
                } else stack.push(c);
            }
            
            if(count == list.size()/ 2 ) answer++;     
            stack.clear();
            loop++;
            
            char c = list.get(0);
            list.remove(0);
            list.add(c);
            
        }    
        return answer;
    }
}