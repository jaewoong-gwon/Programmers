import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<String> answer = new ArrayList<>();
        String[] arr = s.split("");
        
        List<String> list = new ArrayList<>();
        int start = 0;
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i].equals("{")) start = i;
            else if(arr[i].equals("}")){
                list.add(s.substring(start,i+1));
            }
        }
        
        Collections.sort(list,(s1,s2)->{
            return s1.length() - s2.length();
        });
        
        for(String str : list){
            String[] tmp = str.substring(1,str.length()-1).split(",");
            for(String ss : tmp){
                if(!answer.contains(ss)) answer.add(ss);
            }
        }
            
        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
}