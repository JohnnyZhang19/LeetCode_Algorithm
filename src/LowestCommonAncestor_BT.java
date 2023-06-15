import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor_BT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<> ();
        fatherMap.put (root,root);
        process (root, fatherMap);
        HashSet<TreeNode> setP = new HashSet<> ();
        HashSet<TreeNode> setQ = new HashSet<> ();

        TreeNode cur = p;
        while (cur != fatherMap.get (cur)){
            setP.add (cur);
            cur = fatherMap.get (cur);
        }
        setP.add (root);

        TreeNode temp = q;
        while (temp != fatherMap.get (temp)){
            setQ.add (temp);
            for(TreeNode n : setP){
                if (temp == n){
                    return temp;
                }
            }
            temp = fatherMap.get (temp);
        }
        setQ.add (root);
        return root;
    }

    public static void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap){
        if (root == null){
            return;
        }
        fatherMap.put (root.left, root);
        fatherMap.put (root.right, root);
        process (root.left, fatherMap);
        process (root.right, fatherMap);
    }
}
