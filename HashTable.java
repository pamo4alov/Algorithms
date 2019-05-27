package HW_8;

public class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    //--------------------------------------------------------

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize]; //create array
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList(); // fill array
        }
    }

    //--------------------------------------------------------

    public void showTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". "); //output cell number
            hashArray[i].showList();      //output list
        }
    }

    //--------------------------------------------------------

    public int hashFunc(int key) { //hash function
        return key % arraySize;
    }

    //--------------------------------------------------------

    public void insert(Item theItem){
        int key = theItem.getKey();
        int hashVal=hashFunc(key); //hashing
        hashArray[hashVal].insert(theItem); // insert to hashVal position
    }

    //--------------------------------------------------------

    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    //--------------------------------------------------------

    public Item find(int key){
        int hashVal=hashFunc(key); //hashing
        Item theItem = hashArray[hashVal].find(key);
        return theItem;
    }
}
