package HW_6;

import java.util.Random;

/*
 * 1. Создать программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев представляются
 * в виде чисел типа int. Число, которое попадает в узел, должно
 * генерироваться случайным образом в диапазоне от -100 до 100.
 * Запустить программу.
 * 2. Проанализировать, какой процент созданных деревьев является
 * несбалансированными.
 */

public class Main {
    public static final int DEEP_IN_TREE = 6;
    public static final int NUM_OF_TREES = 20;

    public static void main(String[] args) {
        Tree treeArray[] = generateTrees(NUM_OF_TREES);
        showTrees(treeArray);
        showPercentOfDisbalanced(treeArray);
    }

    public static Tree[] generateTrees(int num) {
        Random rnd = new Random();
        Tree treeArray[] = new Tree[num];
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i] = new Tree();
            for (int j = 0; j < DEEP_IN_TREE; j++) {
                treeArray[i].insert(rnd.nextInt(200) - 100); // between -100 and 100
            }
        }
        return treeArray;
    }

    public static void showPercentOfDisbalanced(Tree[] treeArray) {
        int balanced = 0;
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i].isBalanced()) balanced++;
        }
        double percent = ((treeArray.length - balanced) * 100.00) / treeArray.length;
        System.out.println("\nDisbalanced trees: " + percent + "%");
    }

    public static void showTrees(Tree[] treeArray) {
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i].displayTree();
            System.out.println(" - balanced is " + treeArray[i].isBalanced());
        }
    }
}