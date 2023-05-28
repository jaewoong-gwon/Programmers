import java.util.*;
class Solution {
    static Map<String,Integer> dictionary;
    static int index;
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        dictionary = new HashMap<>();
        index = 1;
    
        for(char c = 'A'; c <= 'Z'; c++) dictionary.put(String.valueOf(c),index++);

        while(true){
            String str = find(msg);
            // System.out.println("find : " + str);
            if(str == null){
                answer.add(dictionary.get(msg));
                break;
            }
            for(int i = 1; i <= str.length(); i++){
                String tmp = str.substring(0,i);
                // System.out.println("tmp : " + tmp);
                if(!dictionary.containsKey(tmp)){
                    String s = str.substring(0,i-1);
                    answer.add(dictionary.get(s));
                    msg = process(msg,s);
                    // System.out.println("msg : " + msg);
                    dictionary.put(tmp,index++);
                }
            }
        }

        return answer;
    }

    static String find(String str){
        String result = null;
        for(int i = 1; i <= str.length(); i++){
            String tmp = str.substring(0,i);
            if(!dictionary.containsKey(tmp)){
                result = tmp;
                break;
            }
        }
        return result;
    }
        
    static String process(String original,String s){;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < original.length(); i++){
            char c1 = original.charAt(i);
            if(i < s.length()){
                char c2 = s.charAt(i);
                if(c1 != c2) sb.append(c1);
            } else sb.append(c1);
        }
        return sb.toString();
    }
    
}