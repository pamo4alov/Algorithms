package HW_2_1;

import java.util.Comparator;
import java.util.Date;

/*
 * 1. Повторить реализацию АТД «список» с помощью структуры данных «массив» (не подглядывать, пытаться самим сделать).
 * 2. Провести эксперимент по сравнению эффективности алгоритмов сортировки:
 * a) заполнить список случайными N целыми числами в диапазоне от a до b;
 * b) запустить алгоритмы сортировки, засекая время их выполнения;
 * c) повторить эксперимент M раз;
 * d) данные вывести в таблицу.
 */

public class Pro
{
    public static void main( String[] args ) {

        int n = 15000;
        int a = 1;
        int b = 200;
        int m = 10;
        MyIntegerComparator comparator = new MyIntegerComparator();

        System.out.println("№     select  insert");
        for (int i = 0; i < m; i++) {
            MyArrList<Integer> selectionList = new MyArrList<>();
            for (int j = 0; j < n; j++) {
                selectionList.add((int) (b * Math.random()));
            }
            MyArrList<Integer> insertionList = new MyArrList<>();
            for (int j = 0; j < n; j++) {
                insertionList.add((int) (b * Math.random()));
            }

            System.out.print(i + "     ");

            Date startSelection = new Date();
            selectionList.selectionSort(comparator);
            System.out.print(new Date().getTime() - startSelection.getTime() + "     ");

            Date startInsertion = new Date();
            insertionList.insertionSort(comparator);
            System.out.println(new Date().getTime() - startInsertion.getTime());
        }
    }

    private static class MyIntegerComparator implements Comparator <Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}