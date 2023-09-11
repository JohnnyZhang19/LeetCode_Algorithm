public class PartitionArrayIntoThreeWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int count = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            if (temp == target) {
                count++;
                temp = 0;
            }
        }
        return count >= 3;
    }
}

