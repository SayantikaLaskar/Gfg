//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            int ans = obj.verticalWidth(root);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    
    public class PairNode{
        int index;
        Node node;
        PairNode(int index,Node node){
            this.index=index;
            this.node=node;
        }
    }
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<PairNode> queue=new LinkedList<>();
        int minimum=0;
        int maximum=0;
        PairNode pair=new PairNode(0,root);
        queue.add(pair);
        
        while(!queue.isEmpty()){
            
            PairNode el=queue.remove();
            int index=el.index;
            Node curr=el.node;
            
            if(curr.left!=null){
                queue.add(new PairNode(index-1,curr.left));
                minimum=Math.min(minimum,index-1);
            }
            
            if(curr.right!=null){
                queue.add(new PairNode(index+1,curr.right));
                maximum=Math.max(maximum,index+1);
            }
        }
        return maximum-minimum+1;
        // code here.
    }
    
    
}