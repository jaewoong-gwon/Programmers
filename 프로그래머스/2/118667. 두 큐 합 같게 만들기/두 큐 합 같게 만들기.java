import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int answer = 0;
        Q q1 = new Q(queue1);
        Q q2 = new Q(queue2);
        int loop = 0;
        while(q1.sum != q2.sum){
            if(q1.queue.isEmpty() || q2.queue.isEmpty()) return -1;
            if(loop > 300000) return -1;
            if(q1.sum > q2.sum){
                long num = q1.pop();
                q2.insert(num);
            } else if(q1.sum < q2.sum){
                long num = q2.pop();
                q1.insert(num);
            }
            answer++;
            loop++;
        }
        // System.out.println(q1 +"\n" + q2);
        return answer;
    }
    class Q {
        Queue<Long> queue;
        long sum;
        Q(int[] arr){
            queue = new LinkedList<>();
            sum = 0;
            for(int i : arr){
                Long tmp = Long.valueOf(i);
                queue.offer(Long.valueOf(tmp));
                sum += tmp;
            }   
        }
        
        long pop(){
            long tmp = queue.poll();
            sum -= tmp;
            return tmp;
        }
        void insert(long n){
            queue.offer(n);
            sum += n;
        }
        @Override
        public String toString(){
            return "Q { queue : " + queue + ", sum : " + sum + " }";
        }
    }
}