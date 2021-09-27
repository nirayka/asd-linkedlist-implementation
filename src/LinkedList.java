public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    public static LinkedList insert(LinkedList list,  int data) {

        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty, make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node and insert new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }



    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");

    }


    public static LinkedList deleteByKey(LinkedList list, int key) {
        // Store head node
        Node currNode = list.head, prev = null;

        // CASE 1: If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
            System.out.println("element of value " + key + " has been found and deleted");
            return list;
        }


        // CASE 2: If key isn't at head, search for the key to be deleted & keep track of the previous node
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key, continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode, and it won't be null.
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            System.out.println("element of value " + key + " has been found and deleted");
        }


        // CASE 3: The key is not present. if key was not present in linked list, currNode should be null
        if (currNode == null) {
            System.out.println("element of value " + key + " has not been found");
        }

        return list;
    }


    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        // Store head node
        Node currNode = list.head, prev = null;


        // CASE 1: If index is 0, then head node itself is to be deleted
        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            System.out.println(
                    "element at position " + index + " has been deleted");

            return list;
        }


        // CASE 2: If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;

        // Count for the index to be deleted, keep track of the previous node bc it's needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required position, unlink currNode from linked list
                prev.next = currNode.next;

                System.out.println("element at position " + index + " has been deleted");
                break;
            }
            else {
                // If current position is not the index, continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(
                    "element at position " + index + " not found");
        }

        return list;
    }

}
