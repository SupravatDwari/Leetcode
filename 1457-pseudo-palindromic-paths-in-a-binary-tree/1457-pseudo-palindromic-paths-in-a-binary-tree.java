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
    public int pseudoPalindromicPaths (TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode node, int freq) {
        if (node == null) return 0;
        
        freq = freq ^ (1 << node.val);
        if (node.left == null && node.right == null) {
            return (freq & (freq - 1)) == 0 ? 1 : 0;
            // return Integer.bitCount(freq) <= 1 ? 1 : 0;
        }
        return helper(node.left, freq) + helper(node.right, freq);
    }
}