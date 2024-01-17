class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        even = []
        odd = []
        for num in nums:
            if num % 2 == 0:
                even.append(num)
            else:
                odd.append(num)
        result = []
        for i in range(len(even)):
            result.append(even[i])
            result.append(odd[i])
        return result
    

