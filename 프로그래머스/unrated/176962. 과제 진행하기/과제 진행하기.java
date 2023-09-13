import java.util.*;
class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans,(o1,o2)->{
            return getTime(o1[1]) - getTime(o2[1]);
        });
        
        // for(int i = 0; i < plans.length; i++){
        //     System.out.println(plans[i][0]);
        // }
        
        Queue<Subject> ready = new LinkedList<>();
        Stack<Subject> remain = new Stack<>();
        
        for(int i = 0; i < plans.length; i++){
            ready.offer(new Subject(plans[i][0],plans[i][1],plans[i][2]));
        }
        
        while(!ready.isEmpty()){
            Subject now = ready.poll();
            if(ready.size() >= 1){
                Subject next = ready.peek();
                // 진행시간
                int time = now.start + now.play;
                if(time > next.start){ // 과제 진행 중 다음 과제할 시간이 되었을때
                    now.play -= next.start - now.start;
                    remain.push(now);
                } else if(time == next.start){ // 과제가 끝나고 멈춘 과제 진행할 시간 X
                    answer.add(now.name);
                } else { // 과제가 끝나고 멈춘 과제 진행할 시간 O 
                    answer.add(now.name);
                    while(!remain.isEmpty()){
                        Subject subject = remain.pop();
                        // 진행 가능한 시간이 얼마인지 계산
                        int able = next.start - time;
                        if(able >= subject.play){
                            answer.add(subject.name);
                            time += subject.play;
                        } else {
                            subject.play -= able;
                            remain.push(subject);
                            break;
                        }

                    }
                }
                // 마지막 과제
            } else answer.add(now.name);
        }
        
        if(!remain.isEmpty()){
            while(!remain.isEmpty()){
                answer.add(remain.pop().name);
            }
        }
        return answer;
    }
    
    class Subject{
        public String name;
        public int start;
        public int play;
        
        Subject(String name, String start, String play){
            this.name = name;
            this.start = getTime(start);
            this.play = Integer.parseInt(play);
        }
    }
    
    static int getTime(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}