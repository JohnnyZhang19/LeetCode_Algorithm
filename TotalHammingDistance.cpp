class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.size(); j++){
                count += (nums[j] >> i) & 1;
                //cout << (nums[j] >> i) & 1 << endl;
                //cout << count << endl;
                //cout << endl;
            }
            res += count * (nums.size() - count);
            //cout << res << endl;
        }
        return res;
    }
    
};