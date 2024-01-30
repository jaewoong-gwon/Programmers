class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        /*
            hIndex 는 n 을 넘을 수 없음
        */
        int hIndex = 0;
        while(hIndex <= citations.length){
            int up = 0;
            for(int h : citations){
                if(hIndex <= h) up++;
            }
            if(hIndex <= up && citations.length - up <= hIndex) answer = hIndex;
            hIndex++;
        }
     
        return answer;
    }
}