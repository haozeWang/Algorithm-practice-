/**
 * Created by haozewang on 17/2/21.
 */
public class Delete_Node_in_a_BST {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode par = null;
        TreeNode head = root;
        while (root != null){
            TreeNode temp = root;
            if(root.val == key){
                TreeNode node = helper(root);
                if(par == null){
                    return node;
                }
                else if(par.val > root.val){
                    par.left = node;
                }
                else{
                    par.right = node;
                }
                return head;
            }
            else if(root.val < key){
                root = root.right;
            }
            else {
                root = root.left;
            }
           par = temp;
        }
        return head;
    }
    public static TreeNode helper(TreeNode root){
        if(root.left == null && root.right ==null) return null;
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;
        TreeNode right = root.right;
        TreeNode left = root.left;
        TreeNode temp = left;
        while (temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
        return  left;
    }
    public static void main(String args[]){
       TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
       System.out.print(deleteNode(root,3).left.val);
    }

}
