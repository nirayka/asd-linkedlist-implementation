public class Main {
    public static void main(String[] args) {
        LinkedList grades = new LinkedList();

        grades.insert(grades, 98);
        grades.insert(grades, 91);
        grades.insert(grades, 94);
        grades.insert(grades, 100);
        grades.insert(grades, 97);
        grades.insert(grades, 89);
        grades.insert(grades, 93);
        grades.insert(grades, 97);
        grades.printList(grades);

        grades.deleteByKey(grades, 89);
        grades.printList(grades);

        grades.deleteAtPosition(grades, 4);
        grades.printList(grades);

        grades.size(grades);
        grades.get(grades, 3);
        grades.includes(grades, 101);
        grades.indexOf(grades, 94);
    }
}