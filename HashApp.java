package HW_8;

/*
  1. Создать программу, реализующую метод цепочек
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashApp {
    public static void main(String[] args) throws IOException {
        int key;
        Item theItem;
        int tableSize, numItems, keysPerCell = 100;
        boolean exit = false;

        // input size
        System.out.println("Enter size of hash table: ");
        tableSize = getInt();
        System.out.println("Enter initial number of items: ");
        numItems = getInt();
        //create table
        HashTable theHashTable = new HashTable(tableSize);
        //fill random items
        for (int i = 0; i < numItems; i++) {
            key = (int) (Math.random() * keysPerCell * tableSize);
            theItem = new Item(key);
            theHashTable.insert(theItem);
        }
        while (!exit) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, find, or exit: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.showTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    key = getInt();
                    theHashTable.insert(new Item(key));
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    key = getInt();
                    theHashTable.delete(key);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    key = getInt();
                    theItem = theHashTable.find(key);
                    if (theItem != null)
                        System.out.println("Found " + key);
                    else
                        System.out.println("Could not find " + key);
                    break;
                case 'e':
                    exit = true;
                    System.out.println("Bye. See you later.");
                    return;

                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
    // ADDITIONAL INPUT UTILITES
    //--------------------------------------------------------
    public static String getString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    //--------------------------------------------------------

    public static char getChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().charAt(0);
    }

    //--------------------------------------------------------

    public static int getInt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }


}