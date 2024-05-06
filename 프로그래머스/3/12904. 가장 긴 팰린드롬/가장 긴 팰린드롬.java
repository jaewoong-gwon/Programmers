class Solution {
    public int solution(String s) {
        /*
            부분 문자열의 길이를 Top - Down 으로 하여 팰린드롬이 되는지 확인 -> 너무 많은 반복
            부분 문자열의 길이가 3 -> 가능한 substring 0 3, 1 4 2 5 3 6 4 7
            첫 char 값과 마지막 char 값 부터 각각 증, 감 하면서 똑같을때 펠린 드롬이 되는지 확인?
            
            s.substring -> O(n)
        */
        int answer = 0;
        
        int length = s.length();
        
        while( length > 0 ) {
            int start = 0;
            int end = length - 1; 
            while(start <= end && end < s.length()){
                if(isPalin(s, start, end)) return end - start + 1;
                start++;
                end++;
            }
            length--;
        }
        return answer;
    }
    
    boolean isPalin(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}