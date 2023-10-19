import bisect
class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[int]
        """
        n = len(intervals)
        starts = sorted([(intervals[i][0], i) for i in range(n)])
        ans = [-1] * n
        for i in range(n):
            idx = bisect.bisect_left(starts, (intervals[i][1],))
            if idx < n:
                ans[i] = starts[idx][1]
        return ans