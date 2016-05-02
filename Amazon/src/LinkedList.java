public class LinkedList {
 
    Node head;  
    static Node a, b;
 
     static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
     void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
     Node MergeLists(Node list1, Node list2) {
    	  if (list1 == null) return list2;
    	  if (list2 == null) return list1;

    	  if (list1.data < list2.data) {
    	    list1.next = MergeLists(list1.next, list2);
    	    return list1;
    	  } else {
    	    list2.next = MergeLists(list2.next, list1);
    	    return list2;
    	  }
    	}
 
    public static void main(String[] args) {
 
        LinkedList list = new LinkedList();
        Node result = null;

        list.a = new Node(5);
        list.a.next = new Node(10);
        list.a.next.next = new Node(15);
 
        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(20);
 
        System.out.println("List a before merge :");
        list.printlist(a);
        System.out.println("");
        System.out.println("List b before merge :");
        list.printlist(b);
 
        result = list.MergeLists(a, b);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);
 
    }
}
 