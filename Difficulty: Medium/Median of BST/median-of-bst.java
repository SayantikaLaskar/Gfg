/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findMedian(Node root) {
        // Code here
        ArrayList<Integer> arr = new ArrayList<>();
        helper(arr,root);
        int n = arr.size();
        if(n%2 == 0)  n=n/2;
        else n=(n+1)/2;
        
        return arr.get(n-1);
    }
    
    public static void helper(ArrayList<Integer> arr, Node root){
        if(root == null) return;
        
        helper(arr,root.left);
        arr.add(root.data);
        helper(arr,root.right);
    }
}