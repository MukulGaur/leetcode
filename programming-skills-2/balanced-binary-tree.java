// 110. Balanced Binary Tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        
        if(isBalanced(root.left) == false) return false;
        
        if(isBalanced(root.right) == false) return false;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh-rh)<=1)
            return true;
        else
            return false;
        
    }
    
    int height(TreeNode root){
        if(root==null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh, rh)+1;
    }
}
