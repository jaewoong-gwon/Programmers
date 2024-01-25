import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        s = s.substring(1,s.length()-1);
        
        String[] strArray = s.split("");
 
        List<String> list = new ArrayList<>();
        int idx = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '{') idx = i;
            else if(s.charAt(i) == '}'){
                list.add(s.substring(idx,i+1));
            }
        }
        
        // 길이 짧은순 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        for(String str : list){
            str = str.substring(1,str.length()-1);
            String[] tmp = str.split(",");
            for(String ss : tmp)
                if(!answer.contains(Integer.parseInt(ss))) answer.add(Integer.parseInt(ss));
         }
        return answer;
    }
}