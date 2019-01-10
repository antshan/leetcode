/**
 * 700 二叉搜索树中搜索某个值，返回该子节点
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
       if (root==null){
           return null;
       }
       if (root.val==val){
           return root;
       }else if (root.val>val){
           return searchBST(root.left,val);
       }else {
           return searchBST(root.right,val);
       }

    }
}
