class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        a = sum(aliceSizes)
        b = sum(bobSizes)
        diff = (a-b)//2
        for i in aliceSizes:
            if i-diff in bobSizes:
                return [i,i-diff]
    