package HW_8;

public class SortedList {
    private Item first; //First element link

    //--------------------------------------------------------

    public SortedList() { //constructor
        first = null;
    }

    //---------------------------------------------------------

    public void insert(Item theItem) { //sorted insert
        int key = theItem.getKey();
        Item previous = null; //from first element
        Item current = first;
        //while end of list or currrent <= key
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.nextItem; //select next item
        }
        if (previous == null) //first item of list
            first = theItem; // first -> new item
        else
            previous.nextItem = theItem; // previous -> new element
        theItem.nextItem = current;      // new item -> current
    }

    //---------------------------------------------------------

    public void delete(int key) { //list not empty
        Item previous = null; //from first element
        Item current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.nextItem; //select next item
        }
        if (previous == null) //if first item
            first = first.nextItem; // next item -> first
        else
            previous.nextItem = current.nextItem; // previous -> new element
    }

    //---------------------------------------------------------

    public Item find(int key) {
        Item current = first;

        while (current != null && key <= current.getKey()) {
            if (current.getKey() == key)
                return current;
            current = current.nextItem;
        }
        return null; //item not found
    }

    //---------------------------------------------------------

    public void showList() {
        System.out.print("List (first-->last): ");
        Item current = first;
        while (current != null) {
            current.showItem();
            current = current.nextItem;
        }
        System.out.println("");
    }
}
