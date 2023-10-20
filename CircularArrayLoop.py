class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        def next_index(nums, index):
            # Calculate the next index, taking care of positive and negative integers
            # and wrapping around using modulo
            return (index + nums[index]) % len(nums)
        
        for i in range(len(nums)):
            if nums[i] == 0:
                continue
            
            slow, fast = i, i
            while nums[slow] * nums[next_index(nums, slow)] > 0 and \
                  nums[fast] * nums[next_index(nums, fast)] > 0 and \
                  nums[fast] * nums[next_index(nums, next_index(nums, fast))] > 0:
                
                slow = next_index(nums, slow)
                fast = next_index(nums, next_index(nums, fast))
                
                if slow == fast:
                    # Check for the loop containing more than 1 element
                    if slow == next_index(nums, slow):
                        break
                    return True
            
            # Set all the visited elements to 0
            slow = i
            val = nums[i]
            while val * nums[slow] > 0:
                nums[slow] = 0
                slow = next_index(nums, slow)
                
        return False

