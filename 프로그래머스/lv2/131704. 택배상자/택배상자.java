import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> subContainer = new Stack<>();
        
        int box = 1;

        for(int i = 0; i < order.length; i++){
            // 택배트럭에 실어야하는 상자 번호
            int orderNumber = order[i];
            // System.out.println(i + " : " + subContainer.toString());
            if(!subContainer.isEmpty()){
                if(subContainer.peek() > orderNumber && box > orderNumber) break;
            }
            // 가장 앞에 있는 컨테이너의 상자 번호
            if(box < orderNumber){ // 현재 번호가 실어야할 번호보다 작을 경우
                // 번호 같을때 까지 보조 컨테이너에 보관
                while(box != orderNumber){
                    // System.out.println("order : " + orderNumber  + "\tbox : " + box);
                    subContainer.push(box++);
                }
                if(box + 1 >= order.length) box = order.length;
                else box++;
                
                answer++;       
            } else if(box == orderNumber){
                answer++;
                box++;
            } else { // 현재 번호가 실어야할 번호보다 클 경우 
                // 보조 컨테이너 확인
                while(!subContainer.isEmpty()){
                    int subBox = subContainer.peek();
                    if(subBox == orderNumber){
                        // System.out.println("order : " + orderNumber + "\tsubBox : " + subBox 
                        //                   + "\tbox : " + box);
                        subContainer.pop();
                        answer++;
                        
                    } else {
                        break;
                    }
                }
            }
        }
        return answer;
    } 
}