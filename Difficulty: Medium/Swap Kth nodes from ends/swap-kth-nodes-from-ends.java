/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        // code here
        Node t=head;
        int l=0;
        Node f=null;
        while(t!=null){
            l++;
            if(l==k) f=t;
            t=t.next;
        }
        if(f==null) return head;
        t=head;
        int it=l-k;
        while(it>0){
            t=t.next;
            it--;
        }
        Node las=t;
        int c=f.data;
        f.data=las.data;
        las.data=c;
        return head;
    }
}
