import java.util.ArrayList;
import java.util.List;

/**
 * 965 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class UnivaluedBinaryTree {

    List<Integer> vlas = new ArrayList<>();
    public boolean isUnivalTree(TreeNode root) {

        dfs(root);
        for (int v:vlas){
            if (v!=vlas.get(0))
                return false;
        }
        return true;
    }

    public void dfs(TreeNode treeNode){
        if (treeNode!=null){
            vlas.add(treeNode.val);
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}