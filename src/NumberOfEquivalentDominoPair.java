public class NumberOfEquivalentDominoPair {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int res = 0;
        for (int[] dominoe : dominoes) {
            int num = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            res += count[num];
            count[num]++;
        }
        return res;
        
    }
}
