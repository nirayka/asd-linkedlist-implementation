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


        if (index == size) {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
            return list;
        }


        if (index == 0) {
            Node temp = list.head;
            list.head = newNode;
            list.head.next = temp;
            System.out.println("Element of value " + data + " has been added to the list at index " + index + ".");
            return list;
        }


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


        System.out.println("Sorry, you can't insert an element at a index greater than the size of this list (which is currently " + size + ").");
        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("");

    }


    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println("Element of value " + key + " has been found and deleted.");
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }


        if (currNode != null) {
            prev.next = currNode.next;

            System.out.println("Element of value " + key + " has been found and deleted.");
        }


        if (currNode == null) {
            System.out.println("Element of value " + key + " has not been found.");
        }

        return list;
    }


    public static LinkedList deleteAtIndex(LinkedList list, int index) {
        Node currNode = list.head, prev = null;


        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println("Element at index " + index + " has been deleted.");
            return list;
        }


        int counter = 0;


        while (currNode != null) {
            if (counter == index) {
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
        System.out.println("This LinkedList is " + counter + " elements long.");
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
            System.out.println("" + key + " was not found in the list.");
        } else {
            System.out.println("" + key + " was found at element " + counter + ".");
        }
        return true;
    }

    public static int indexOf(LinkedList list, int key) {
        Node currNode = list.head, prev = null;
        int counter = 0;

        if (currNode != null && currNode.data == key) {
            System.out.println("The first index of value " + key + " is " + counter + ".");
            return counter;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }

        if (currNode != null) {
            System.out.println("The first index with value " + key + " is " + counter + ".");
        } else {
            System.out.println("Element of value " + key + " could not be found.");
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