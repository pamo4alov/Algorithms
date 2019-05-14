package HW_4;

public class ListApp {
    public static void main(String[] args) {
        System.gc();
        LinkedList list = new LinkedList();
        list.insert("Donald", 20);
        list.insert("Bill", 25);
        list.insert("Sem", 30);

        list.display();
        System.out.println();
        if (!list.isEmpty()) list.delete();

        list.display();
    }
}
