/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    int a=-1;
    void inorder(Node root, int k){
        // code here.
        if(root==null)  return;
        inorder(root.left, k);
        if(root.data<=k){
            a=Math.max(a, root.data);
            inorder(root.right, k);
        }
    }
    public int findMaxFork(Node root, int k) { 
        inorder(root, k);
        return a;
    }
}