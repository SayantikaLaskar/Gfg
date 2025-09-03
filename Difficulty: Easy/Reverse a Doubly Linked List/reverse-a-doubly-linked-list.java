/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node c=head;
         Node t=null;
         while(c!=null){
             t=c.prev;
             c.prev=c.next;
             c.next=t;
             c=c.prev;
         }
         if(t!=null){
             head=t.prev;
         }
         return head;
    }
}