class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> temp;
        dfs(nums, 0, temp, res);
        return res;
    }
    void dfs(vector<int>& nums, int start, vector<int>& temp, vector<vector<int>>& res) {
        if (temp.size() > 1) res.push_back(temp);
        unordered_set<int> st;
        for (int i = start; i < nums.size(); i++) {
            if (st.find(nums[i]) != st.end()) continue;
            if (temp.empty() || temp.back() <= nums[i]) {
                temp.push_back(nums[i]);
                dfs(nums, i + 1, temp, res);
                temp.pop_back();
                st.insert(nums[i]);
        
            }
        }
    }
};