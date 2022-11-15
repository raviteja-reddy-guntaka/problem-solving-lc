/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return count(root, 1);
    }
    
    private int count(TreeNode root, int value) {
        if (root.left == null && root.right == null)
            return value;
        
        int right = 0, left = 0;
        if (root.right != null)
            right =  count(root.right, 2*value+1);
        
        if (root.left != null)
            left = count(root.left, 2*value);
        
        return Math.max(left, right);
    }
}