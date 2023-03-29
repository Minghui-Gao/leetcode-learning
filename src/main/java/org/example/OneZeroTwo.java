package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OneZeroTwo {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();
            for(int i = 0; i < levels; i ++) {
                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }
                subLevels.add(q.poll().val);
            }
            result.add(subLevels);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
