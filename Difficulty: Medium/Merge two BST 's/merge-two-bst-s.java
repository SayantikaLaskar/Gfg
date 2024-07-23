//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    private void DfsPannuBro(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        DfsPannuBro(root.left, list);
        list.add(root.data);
        DfsPannuBro(root.right, list);
    }
    
    private List<Integer> mergePannuBro(List<Integer> list1, List<Integer> list2){
        List<Integer> res = new ArrayList<>();
        
        int n = list1.size(), m = list2.size();
        int i = 0, j = 0;
        
        while(i<n && j<m){
            int a = list1.get(i), b = list2.get(j);
            if(a < b){
                res.add(a);
                i++;
            }
            else{
                res.add(b);
                j++;
            }
        }
        
        while(i<n){
            res.add(list1.get(i++));
        }
        
        while(j<m){
            res.add(list2.get(j++));
        }
        
        return res;
    }
    
    public List<Integer> merge(Node root1, Node root2) {
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        DfsPannuBro(root1, list1);
        DfsPannuBro(root2, list2);
        
        return mergePannuBro(list1, list2);
    }
}
