public class Main {
    public static void main(String[] args) {
        DList linkedList = new DList();
        DListNode node1 = new DListNode("1");
        DListNode node2 = new DListNode("2");
        linkedList.add(node1);
        linkedList.add(node2);
        System.out.println("The Double Linked List looks like: " + linkedList.printList());
        linkedList.insertFront(new DListNode("3"));
        System.out.println("Adding 3 in the front makes the list look like: " + linkedList.printList());
        linkedList.insertEnd(new DListNode("4"));
        System.out.println("Adding 4 in the end make the list look like: " + linkedList.printList());
        System.out.println("The second element of the list is: " + linkedList.get(2));
        System.out.println("The third element of the list is: " + linkedList.get(3));
        linkedList.remove(2);
        System.out.println("Removing the second element makes the list look like: " + linkedList.printList());
    }
}
