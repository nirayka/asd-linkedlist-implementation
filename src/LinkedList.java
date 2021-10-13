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

        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        return list;
    }

    public static LinkedList insert(LinkedList list, int data, int index) {
        Node newNode = new Node(data);
        newNode.next = null;

       int size = list.returnSize(list);

        // CASE 1: index is to be inserted at the end
        if (index == size) {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
            return list;
        }

        // CASE 2: data is to be inserted at the head
        if (index == 0) {
            Node temp = list.head;
            list.head = newNode;
            list.head.next = temp;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
            return list;
        }

        // CASE 3: the index is >head and <tail
        if ((index < size) && (index > 0)) {
            Node currNode = list.head, prev = null;
            int counter = 0;

            while (currNode != null && counter < index - 1) {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
            Node temp = currNode.next;
            currNode.next = newNode;
            newNode.next = temp;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
            return list;
        }

        // CASE 4: the index is greater than the length of the list.
        System.out.println("Sorry, you can't insert an element at a index greater than the size of this list (which is currently " + size + ").");
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
        Node currNode = list.head, prev = null;

        // CASE 1: If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
            System.out.println("Element of value " + key + " has been found and deleted.");
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

            System.out.println("Element of value " + key + " has been found and deleted.");
        }


        // CASE 3: The key is not present. if key was not present in linked list, currNode should be null
        if (currNode == null) {
            System.out.println("Element of value " + key + " has not been found.");
        }

        return list;
    }


    public static LinkedList deleteAtIndex(LinkedList list, int index) {
        Node currNode = list.head, prev = null;

        // CASE 1: If index is 0, head node is to be deleted
        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head
            System.out.println("Element at index " + index + " has been deleted.");
            return list;
        }

        // CASE 2: If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;

        // Count for the index to be deleted, keep track of the previous node bc it's needed to change currNode.next
        while (currNode != null) {
            if (counter == index) {
                // Since the currNode is the required index, unlink currNode from linked list
                prev.next = currNode.next;

                System.out.println("Element at index " + index + " has been deleted.");
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println("Element at index " + index + " not found.");
        }

        return list;
    }

    public static int size(LinkedList list) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        while (currNode != null) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }
        System.out.println("This LinkedList is " + counter + " elements long.\n");
        return counter;
    }

    public static int get(LinkedList list, int index) {
        Node currNode = list.head, prev = null;
        int value = -1;
        int counter = 0;
        int size = list.returnSize(list);

        if (index >= size || index < 0) {
            System.out.println("Sorry, there's no value at that index.");
            return value;
        } else {
            while (currNode != null) {
                if (counter == index) {
                    value = currNode.data;
                    System.out.println("The value at index " + index + " is " + value + ".");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                    counter++;
                }
            }
            return value;
        }
    }

    public static boolean includes(LinkedList list, int key){
        int counter = returnIndexOf(list, key);
        if (counter == -1) {
            System.out.println("\n" + key + " was not found in the list.");
        } else {
            System.out.println("\n" + key + " was found at element " + counter + ".");
        }
        return true;
    }

    public static int indexOf(LinkedList list, int key) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        if (currNode != null && currNode.data == key) {
            System.out.println("\nThe first index of value " + key + " is " + counter + ".");
            return counter;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }

        if (currNode != null) {
            System.out.println("\nThe first index with value " + key + " is " + counter + ".");
        } else {
            System.out.println("\nElement of value " + key + " could not be found.");
        }

        return counter;
    }

    public static int returnIndexOf(LinkedList list, int key) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        if (currNode != null && currNode.data == key) {
            return counter;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }

        if (currNode != null) {
            return counter;
        } else {
            counter = -1;
        }

        return counter;
    }

    public static int returnSize(LinkedList list) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        while (currNode != null) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

}