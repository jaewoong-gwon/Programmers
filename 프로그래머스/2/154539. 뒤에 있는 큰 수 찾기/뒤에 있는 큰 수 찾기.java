import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        /*
            배열의 뒤에서 부터 접근
            스택이 비어있다 -> 자신 보다 큰 수 없음 -> -1 저장
            스택이 비어있지 않다 -> 자신 보다 큰 수가 나올 때 까지 pop
        */
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--){
            while(!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    answer.add(stack.peek());
                    break;
                }
                else stack.pop();
            }
            
            if(stack.isEmpty()) answer.add(-1);
            stack.push(numbers[i]);
        }
        Collections.reverse(answer);
        return answer.stream().mapToInt(x->x).toArray();
    }
}