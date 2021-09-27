public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 3);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 8);
        list.printList(list);

        list.deleteByKey(list, 1);
        list.printList(list);


        list.deleteAtPosition(list, 2);
        list.printList(list);

    }
}