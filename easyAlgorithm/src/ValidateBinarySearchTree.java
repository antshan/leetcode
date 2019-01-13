/**
 * 98 验证BST
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode treeNode,Integer min,Integer max){
        if (treeNode==null) return true;
        if (min != null && treeNode.val<=min) return false;
        if (max != null && treeNode.val>=max) return false;
        return helper(treeNode.left,min,treeNode.val) && helper(treeNode.right,treeNode.val,max);
    }
}
