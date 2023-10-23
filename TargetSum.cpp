class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum += abs(num);
        }
        if(sum < abs(target) || (sum + target)%2 == 1){
            return 0;
        }
        int s = (sum + target)/2;
        vector<int> dp(s+1, 0);
        dp[0] = 1;
        for(int num: nums){
            for(int i = s; i >= num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[s];
    }
};