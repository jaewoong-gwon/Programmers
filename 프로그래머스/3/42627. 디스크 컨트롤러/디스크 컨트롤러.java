import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        /*
            대기 시간 + 작업 시간 = 요청 ~ 종료까지 걸린 시간
            대기 시간 = 작업을 시작하는 시간 - 요청된 시간
            1. 작업 요청 시간 순서대로 정렬
            2. 현재 대기하고 있는 작업 중 작업 소요시간이 짧은 순서대로 정렬
            -> 우선 순위 큐 
            
            시간++
            request 에서 현재 시간에 요청된게 있는지 확인 
            요청 된게 있으면
            reqeust -> ready 로
            ready 에 job 이있으면 -> run 으로 처리함
            작업 소요시간이 현재시간과 같을때 run 에서 빼고 요청 ~ 종료시간 계산
            뺸 뒤 같은 시간에
            ready 에 job 이 있으면 run 으로 처리
        */
        int answer = 0;
        
        PriorityQueue<Job> request = new PriorityQueue<>((j1,j2)->{
            return j1.arrive - j2.arrive;
        });
        
        for(int[] arr : jobs){
            request.offer(new Job(arr[0],arr[1]));
        }
        
        PriorityQueue<Job> ready = new PriorityQueue<>((j1,j2) ->{
            return j1.cost - j2.cost; 
        });
        
        Queue<Job> running = new LinkedList<>();
        int time = 0;
        
        while(true){
            if(request.isEmpty() && ready.isEmpty() && running.isEmpty()) break;
            while(!request.isEmpty()){
                if(time >= request.peek().arrive) ready.offer(request.poll());
                else break;
            }
            if(!ready.isEmpty()){
                if(running.isEmpty()){
                    Job current = ready.poll();
                    current.start = time;
                    running.offer(current);
                }
            }
            if(!running.isEmpty()){
                if(running.peek().start + running.peek().cost == time){
                    Job current = running.poll();
                    int wait = current.start - current.arrive;
                    answer += wait + current.cost;
                    if(!ready.isEmpty()){
                        current = ready.poll();
                        current.start = time;
                        running.offer(current);
                    } 
                }
            }
            time++;
        }
            
     
        return (int) Math.floor(answer / jobs.length);
    }
    
    class Job {
        int arrive;
        int cost;
        int start;
        Job(int a, int c){ arrive = a; cost = c; start = 0;}
        
        @Override
        public String toString(){
            return "Job{ arrive : " + arrive + ", cost : " + cost + " }";
        }
    }
}