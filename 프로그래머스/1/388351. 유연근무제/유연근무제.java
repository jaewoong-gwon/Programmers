class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        /*
            출근 희망 시각 + 10분
            시각은 시 * 100 + 분 형태로 표현
            
            1. 주말은 이벤트에 영향 x -> 주말 판정 필요
            2. 시간 계산 
            -> + 10 분을 했을때 60분을 넘어갈 경우, 60분일경우
        */
        int answer = 0;
        for(int i = 0; i < timelogs.length; i++) {
            int time = getDesireTime(schedules[i] + 10);
            //System.out.println(time);
            int count = 0;
            for(int j = 0; j < timelogs[i].length; j++) {
                // 주말이면 패스
                if(isWeekend(startday++)) continue;
                
                // 지각하면 패스
                if(time < timelogs[i][j]) continue;
                
                count++;
            }
            if(count == 5) answer++;
        }
        return answer;
    }
    
    boolean isWeekend (int day) {
        return day % 7 == 6 || day % 7 == 0;
    }
    
    int getDesireTime(int time) {
        // 4 자리로 만들기
        String strTime = Integer.toString(time);
        if(strTime.length() == 3) strTime = "0" + strTime;
        
        // 2개씩 쪼개기
        String hour = strTime.substring(0,2);
        String minute = strTime.substring(2,4);
        // System.out.println(hour + " : " + minute);
        
        int h = Integer.parseInt(hour);
        int m = Integer.parseInt(minute);
        
        if(m >= 60){
            if(++h < 10) hour = "0" + Integer.toString(h);
            else hour = Integer.toString(h);
            m = m % 60;
            if(m < 10) minute = "0" + Integer.toString(m);
            else minute = Integer.toString(m);
        }
        
        return Integer.parseInt(hour + minute);
    }
    
    
}