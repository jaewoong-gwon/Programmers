import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        return Integer.parseInt(
            Arrays.stream(num_list)
            .filter(x -> x % 2 == 1)
            .mapToObj(x -> String.valueOf(x))
            .collect(Collectors.joining(""))) + 
            Integer.parseInt(
            Arrays.stream(num_list)
            .filter(x -> x % 2 == 0)
            .mapToObj(x -> String.valueOf(x))
            .collect(Collectors.joining("")));
    }
}