package com.contactsunny.poc.reverselinkedlist;

public class App {

    public static void main(String[] args) {

        Node<Integer> node1 = new Node<Integer>();
        node1.setData(1);

        Node<Integer> node2 = new Node<Integer>();
        node2.setData(2);

        Node<Integer> node3 = new Node<Integer>();
        node3.setData(3);

        Node<Integer> node4 = new Node<Integer>();
        node4.setData(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        traverseLinkedList(node1);

        // The reversal method returns the new head of the linked list.
        Node<Integer> head = reverseLinkedLIst(node1);

        System.out.println("-----------------------------");
        System.out.println("Traversing reversed list");
        traverseLinkedList(head);
    }

    /**
     * This method reverses a linked list in place
     *   ** OR **
     * This methods mutates a linked list to reverse it.
     *
     * @param node The head of the original node.
     * @return The new head of the reversed node.
     */
    private static Node<Integer> reverseLinkedLIst(Node<Integer> node) {
        // Creating three pointers to hold the previous, current, and the next node.
        Node<Integer> previous = null;
        // The current node is set to the current head of the linked list.
        Node<Integer> current = node;
        Node<Integer> next = null;

        // Iterating over the linked list till we hit the end.
        while (current != null) {
            // Creating a reference to the next node in the list.
            next = current.getNext();
            // Setting the current node's next to the previous, there by reversing the direction
            // for the current node.
            current.setNext(previous);
            // Moving the pointer of the previous node to the current node, which will be the
            // previous node of the next node in the iteration.
            previous = current;
            // Moving the pointer to the next node for the iteration.
            current = next;
        }

        // The previous node after all the iterations will be the new head
        // of the reversed linked list. Returning this for traversal.
        return previous;
    }

    private static void traverseLinkedList(Node<Integer> node) {

        while (node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println("*");
        System.out.println("-----------------------------");
    }
}
