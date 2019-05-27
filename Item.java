package HW_8;

public class Item {
    private int data;
    public Item nextItem = null;

    //--------------------------------------------------------

    public Item(int data) {
        this.data = data;
    }

    //--------------------------------------------------------

    public int getKey() {
        return this.data;
    }

    //--------------------------------------------------------

    public void showItem() {
        System.out.print(data + " ");
    }
}
