public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(list, 98);
        list.insert(list, 91);
        list.insert(list, 94);
        list.insert(list, 100);
        list.insert(list, 97);
        list.insert(list, 89);
        list.insert(list, 93);
        list.insert(list, 97);
        list.printList(list);

        list.deleteByKey(list, 89);
        list.printList(list);

        list.deleteAtPosition(list, 4);
        list.printList(list);

        list.size(list);
        list.get(list, 3);
        list.indexOf(list, 94);
    }
}