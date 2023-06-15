public class ConvertArrayToBST {
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     if(nums.length == 0){
    //         return null;
    //     }else{
    //         int middle = nums.length/2;
    //         TreeNode result = new TreeNode(nums[middle]);
    //         result.left = new TreeNode(nums[0]);
    //         result.right = new TreeNode(nums[middle+1]);
    //         TreeNode tempLeft = result.left;
    //         TreeNode tempRight = result.right;
    //         for(int i = 1; i < middle; i++){
    //             tempLeft.right = new TreeNode(nums[i]);
    //             tempRight.right = new TreeNode(nums[i+middle+1]);
    //             tempLeft = tempLeft.right;
    //             tempRight = tempRight.right;
    //         }
    //         return result;
    //     }
        
    // }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBSTRecursive(nums, 0, nums.length - 1);
    }

    private TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBSTRecursive(nums, left, mid - 1);
        node.right = constructBSTRecursive(nums, mid + 1, right);
        return node;
    }
}
