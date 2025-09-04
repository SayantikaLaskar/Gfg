/*
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
    public Node reverseKGroup(Node head, int k) {
        // code here
        Node t=head;
        Node c=head;
        Node p=null;
        int cn=0;
        while(c!=null){
            Node n=c.next;
            c.next=p;
            p=c;
            if(++cn==k || n==null){
                p=t;
                if(t==head){
                    head=c;
                }else{
                    t.next.next=c;
                }
                t.next=n;
                t=n;
                cn=0;
            }
            c=n;
        }
        return head;
    }
}