import java.util.*;
class Solution {
    public int solution(String s) {
        /*
            s 의 길이는 1000 이하
            단위 개수, 특정 개수로 스트링 나누기
            반복되는 스트링 확인
        */
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        for(int i = 1; i < s.length(); i++){
            String str = compress(i,s);
            if(answer > str.length()) answer = str.length();
            //System.out.println(i + " : " + str);
        }
        return answer;
    }
    String compress(int n, String s){
        int startIdx = 0;
        int endIdx = n;
        /*
            1. n 개의 단위로 문자열 자름
            2. 이전의 문자열과 같다면 count++
            3. 다르다면 StringBuilder에 메모후 변수 초기화
        */
        boolean first = true;
        String pre = "";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while(startIdx <= s.length()){
            String str = "";
            if(endIdx <= s.length()) str = s.substring(startIdx,endIdx);
            else str = s.substring(startIdx,s.length());
            if(first){
                pre = str;
                first = false;
            } else {
                if(pre.equals(str)){
                    count++;
                } else {
                    if(count == 1) sb.append(pre);
                    else {
                        sb.append(count).append(pre);
                    }
                    pre = str;
                    count = 1;
                }
            }
            // System.out.println("sb : " + sb.toString() + "\t count : " + count + "\t pre : " + pre + "\t str : " + str);
            startIdx += n;
            endIdx += n;
        }
        
        if(!pre.isEmpty()) sb.append(pre);
        
        return sb.toString();
    }
}