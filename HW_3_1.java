package HW_3_1;

import java.util.InputMismatchException;
import java.util.Scanner;


/*
 *Задание:
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
 * 3. Создать класс для реализации дека.
 */

public class HW_3_1 {
    public static void main(String[] args) {
        int command = getCommand("1-Stack, 2-Queue, 3-Deque, 4-String reverse", 4);
        switch (command){
            case 1:
                runStack();
                break;
            case 2:
                runQueue();
                break;
            case 3:
                runDeque();
                break;
            case 4:
                runStringReverse();
                break;
        }

    }

    /*
     * Method displays a message and receives the command number from the console, while catching exceptions..
     * Required to perform the "menu" when performing the test written methods.
     * @param - message - Message to the user
     * @param - numberOfOptions - number of answer options
     * @return - number of the selected option
     */
    static int getCommand(String message, int numberOfOptions){
        int command;
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println(message);
                command = sc.nextByte();
                if ((command > 0) && (command <= numberOfOptions)) {
                    return command;
                } else {
                    System.out.println("Incorrect input format!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }

    /*
     * Method is intended to get an integer value from the console and catch exceptions.
     * @return - integer value entered from console.
     */
    static int getInt(){
        int number;
        Scanner sc = new Scanner(System.in);
        while (true){

            try {
                System.out.println("Enter an integer");
                number = sc.nextByte();
                return number;
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input format!");
                sc.next();
            }
        }
    }

    /*
     * Method fills the deque and takes values from it using the console.
     */
    static  void runDeque(){
        Deque deque = new Deque(10);
        while (true){
            int dequeCommand = getCommand("1-Insert left Element, 2-Remove left element, 3-Insert right Element, 4-Remove right element, 5 - Exit", 5);
            switch (dequeCommand){
                case 1:
                    if (!deque.isFull()) {
                        deque.insertLeft(getInt());
                    } else {
                        System.out.println("Deque is full!");
                    }
                    break;
                case 2:
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeLeft());
                    } else {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 3:
                    if (!deque.isFull()) {
                        deque.insertRight(getInt());
                    } else {
                        System.out.println("Deque is full!");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        System.out.println(deque.removeRight());
                    } else {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 5:
                    System.exit(0);
            }
            System.out.println(deque.toString());
        }
    }

    /*
     * Method fills the queue and takes values from it using the console.
     */
    static  void  runQueue(){
        Queue queue = new Queue(10);
        while (true){
            int queueCommand = getCommand("1-Insert Element, 2-Remove element, 3 - Exit", 3);
            switch (queueCommand){
                case 1:
                    if (!queue.isFull()){
                        queue.insert(getInt());
                    } else {
                        System.out.println("Queue is full!");
                    }
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println(queue.remove());
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
            System.out.println(queue.toString());
        }
    }

    /*
     * Method fills the stack and takes values from it using the console.
     */
    static void runStack(){
        Stack stack = new Stack(10);
        while (true){
            int stackCommand = getCommand("1-Push Element, 2-Pop element, 3 - Exit", 3);
            switch (stackCommand){
                case 1:
                    if (!stack.isFull()) {
                        stack.push(getInt());
                    } else {
                        System.out.println("Stack is full!");
                    }
                    break;
                case 2:
                    if (!stack.isEmpty()){
                        System.out.println(stack.pop());
                    }
                    else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
            System.out.println(stack.toString());
        }
    }

    /*
     * Method reverses the string using the CharStack class.
     */
    static void runStringReverse(){
        while (true) {
            int command = getCommand("1-Reverse string, 2 - Exit", 2);
            switch (command) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the string");
                    String string = new String(sc.nextLine());
                    CharStack charStack = new CharStack(string.length());
                    for (int i = 0; i < string.length(); i++) {
                        charStack.push(string.charAt(i));
                    }
                    for (int i = 0; i < string.length(); i++) {
                        System.out.print(charStack.pop());
                    }
                    System.out.println();
                    break;

                case 2:
                    System.exit(0);
            }
        }
    }
}
