import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4){
            return false;
        }
        int sum = 0;
        for(int stick : matchsticks){
            sum += stick;
        }
        if(sum % 4 != 0){
            return false;
        }
        int side = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, side);
    }
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (backtrack(matchsticks, sides, index + 1, target)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }

        return false;
    }

    private void reverse(int[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
