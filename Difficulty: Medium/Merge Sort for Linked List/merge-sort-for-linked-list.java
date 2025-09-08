/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        Node t=head;
        int c=0;
        while(t!=null){
            c++;
            t=t.next;
        }
        int[] a=new int[c];
        t=head;
        for(int i=0; i<c; i++){
            a[i]=t.data;
            t=t.next;
        }
        Arrays.sort(a);
        t=head;
        int j=0;
        while(t!=null){
            t.data=a[j++];
            t=t.next;
        }
        return head;
    }
}