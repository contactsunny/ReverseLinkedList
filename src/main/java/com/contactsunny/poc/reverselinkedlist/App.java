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

        // Cloning the linked list so that we can use a new linked list
        // for reversing it recursively. As the original list would have already
        // been reversed.
        Node<Integer> clonedHead = cloneLinkedList(node1);
        System.out.println("Cloned List");
        traverseLinkedList(clonedHead);

        // The reversal method returns the new head of the linked list.
        Node<Integer> head = reverseLinkedList(node1);
        System.out.println("-----------------------------");
        System.out.println("Traversing reversed list");
        traverseLinkedList(head);

        // Calling method to reverse the list recursively.
        head = reverseLinkedListRecursively(clonedHead);
        System.out.println("-----------------------------");
        System.out.println("Traversing recursively reversed list");
        traverseLinkedList(head);
    }

    /**
     * Cloning the linked list to use it as the origin list for the recursive reversal.
     *
     * @param node The head node of the original linked list.
     *
     * @return clonedHead The head node of the new cloned linked list.
     */
    private static Node<Integer> cloneLinkedList(Node<Integer> node) {
        // Creating a pointer for the new head of the reversed linked list.
        Node<Integer> clonedHead = null;
        // Creating a pointer to hold the previous node of the reversed list.
        Node<Integer> previous = null;
        // Iterating over all the nodes.
        while (node != null) {
            // Creating a new node for the new linked list.
            Node<Integer> current = new Node<Integer>();
            // Copying the data from the original list.
            current.setData(node.getData());
            // In the first iteration, the head will be null.
            // So setting the head here.
            if (clonedHead == null) {
                clonedHead = current;
            } else {
                // In all other iterations, we have to set the previous node's next pointer
                // to the current node. Doing it here.
                previous.setNext(current);
            }
            // The previous node becomes the current for the next iteration.
            previous = current;
            // And the next node of the original list becomes the next node.
            node = node.getNext();
        }

        return clonedHead;
    }

    /**
     * Method to reverse a given linked list recursively.
     *
     * @param node The head of the origin linked list.
     *
     * @return The new head of the reversed linked list.
     */
    private static Node<Integer> reverseLinkedListRecursively(Node<Integer> node) {
        // Creating three pointers to hold the previous, current, and the next node.
        Node<Integer> previous = null;
        // The current node is set to the current head of the linked list.
        Node<Integer> current = node;
        // Calling the method to reverse the list.
        return getReversedList(previous, current);
    }

    /**
     * Method to reverse a linked list  recursively. This method will reverse the list one node at a time,
     * till we hit the end of the list. The last node returns itself as the new head of the reversed list.
     * This method uses the same logic that I have used in the reverseLinkedList() method. But instead of
     * doing it sequentially using a while() loop, this is using recursion.
     *
     * @param previous The previous node.
     * @param current The current node.
     * @return The new head of the reversed linked list.
     */
    private static Node<Integer> getReversedList(Node<Integer> previous, Node<Integer> current) {
        // If the current node is null, it means we have hit the end of the linked list.
        // This means that the previous node is the new head of the reversed linked list.
        if (current == null) {
            return previous;
        }

        // Getting a pointer to the next node.
        Node<Integer> next = current.getNext();
        // Setting the next pointer of the current node to the previous node, thereby changing the direction.
        current.setNext(previous);
        // Moving the pointer of the previous node to the current node, which will be the
        // previous node of the next node in the iteration.
        previous = current;
        // Moving the pointer to the next node for the iteration.
        current = next;
        // Calling the method recursively to reverse the next sub-list.
        return getReversedList(previous, current);
    }

    /**
     * This method reverses a linked list in place
     *   ** OR **
     * This methods mutates a linked list to reverse it.
     *
     * @param node The head of the original node.
     * @return The new head of the reversed node.
     */
    private static Node<Integer> reverseLinkedList(Node<Integer> node) {
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
