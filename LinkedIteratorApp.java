package HW_4;

public class LinkedIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedIterator itr = new LinkedIterator(list);

        itr.insertAfter("Eric", 5);
        itr.insertBefore("Aron", 10);

        list.display();
        itr.reset();

        System.out.println();
        itr.getCurrent().display();

        itr.nextLink();

        itr.insertAfter("Mark",15);
        System.out.println();
        list.display();
        itr.insertBefore("Tom", 20);
        System.out.println();
        list.display();

        itr.reset();
        itr.deleteCurrent();
        System.out.println();
        list.display();
    }
}

