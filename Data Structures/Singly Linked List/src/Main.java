public class Main {
    public static void main(String[] args) {
        SList linkedList = new SList();
        SListNode node1 = new SListNode("1");
        SListNode node2 = new SListNode("2");
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.insertFront("3");
        System.out.println("The Singly Linked List looks like: " + linkedList.printList());
        System.out.println("There are " + linkedList.getSize() + " elements");
        System.out.println("The first element is: " + linkedList.getFirst());
        System.out.println("The second element is: " + linkedList.get(2));
        linkedList.remove(2);
        System.out.println("If we remove the second element, the list looks like: " + linkedList.printList());
        linkedList.add(new SListNode("1"));
        System.out.println("Adding 1 back into the list makes the list look like: " + linkedList.printList());
    }
}