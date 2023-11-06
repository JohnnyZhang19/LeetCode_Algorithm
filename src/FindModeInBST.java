import java.util.ArrayList;
import java.util.List;
public class FindModeInBST {
    private Integer prev = null;
    private int count = 1;
    private int max = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        
        // Convert the list of modes to an array.
        int[] modeArray = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            modeArray[i] = modes.get(i);
        }
        
        return modeArray;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        
        inOrder(node.left);
        
        if (prev != null) {
            if (node.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if (count > max) {
            max = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == max) {
            modes.add(node.val);
        }
        
        prev = node.val;
        
        inOrder(node.right);
    }
    

}
