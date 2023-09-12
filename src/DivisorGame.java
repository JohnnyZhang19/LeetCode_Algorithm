public class DivisorGame {
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && dp[i - j] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n] == 1;
    }
}
