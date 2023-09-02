class Solution {
    static int[] position;
    static String[] map;
    public int[] solution(String[] park, String[] routes) {
        /*
            E : y 좌표 + 1
            W : y 좌표 - 1
            N : x 좌표 - 1
            S : x 좌표 + 1
        */
        int[] answer = new int[2];
        
        for(int i = 0; i < park[i].length(); i++){
            if(park[i].indexOf("S") != -1) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            } 
        }
        
        position = answer.clone();
        map = park.clone();
        
        for(String s : routes){
            String[] order = s.split(" ");
            String op = order[0];
            int n = Integer.parseInt(order[1]);
            move(op,n);
        }
        return position;
    }
    
    void move(String op, int n){
        int x = position[0];
        int y = position[1];
        //System.out.println(x + " , " + y);
        if(op.equals("E")){
            if(y + n <= map[x].length() - 1){
                String[] tmp = map[x].split("");
                for(int i = y + 1; i <= y+n; i++){
                    if(tmp[i].equals("X")) return;
                }
                position[1] += n;
            }
        } else if(op.equals("W")){
            if(y - n >= 0){
                String[] tmp = map[x].split("");
                for(int i = y - 1; i >= y - n; i--){
                    if(tmp[i].equals("X")) return;
                }
                position[1] -= n;
            }
        } else if(op.equals("S")){
            if(x + n <= map.length - 1){
                for(int i = x + 1; i <= x + n; i++){
                    if(map[i].split("")[y].equals("X")) return;
                }
                position[0] += n;
            }
        } else {
            if(x - n >= 0){
                for(int i = x -1; i >= x -n; i--){
                   if(map[i].split("")[y].equals("X")) return;
                }
                position[0] -= n;
            }
        }
    }
}