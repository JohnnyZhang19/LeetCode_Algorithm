class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) < 3:
            return False
        
        # This will hold the second biggest number, i.e., '2' in "132" 
        second_max = float('-inf')
        
        # This will hold potential candidates for the '3' in "132"
        stack = []
        
        # Traverse the list from right to left
        for num in reversed(nums):
            # If we find a number smaller than the second biggest, 
            # then we have found a "132" pattern
            if num < second_max:
                return True
            
            # If the current number is bigger or equal to the top of the stack,
            # then update the second biggest number
            while stack and num > stack[-1]:
                second_max = stack.pop()
            
            # Add the current number to the stack
            stack.append(num)
            
        return False