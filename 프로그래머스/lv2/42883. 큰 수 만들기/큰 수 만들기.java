import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] charArray = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        int count = 0;
        for(int i = 0; i < charArray.length; i++){
            char num = charArray[i];
            while(stack.size() != 0 && stack.peek() < num && count < k){
                stack.pop();
                count++;
            } 
            stack.push(num);
        }
        
        while(count < k){
            stack.pop();
            count++;
        }
        
        for(char c : stack) answer.append(c);
        
        
        
        return answer.toString();
     }
}