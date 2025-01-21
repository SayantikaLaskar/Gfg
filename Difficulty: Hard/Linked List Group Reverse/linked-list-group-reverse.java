//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null) return head;
        if(len(head)<k) return rev(head);
        Node curr=head,next=null,prev=null;
        for(int i=0;i<k;i++){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        }
        head.next=reverseKGroup(curr,k);
        return prev;
    }
    private static int len(Node head){
        int n=0;
        while(head!=null){
            n++;
            head=head.next;
        }
        return n;
    }
    private static Node rev(Node head){
        Node curr=head,next=null,prev=null;
        while(curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        }
        return prev;
    }
}
