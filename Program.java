package HW_5;

//1. Написать программу по возведению целого числа в натуральную степень циклическим и рекурсивным алгоритмом.

public class Program {
    public static void main(String[] args) {
        System.out.println("Возведение в степень Рекурсия");
        System.out.println(expRec(3, 7));
        System.out.println("\nВозведение в степень Цикл");
        System.out.println(exp(3, 7));
        System.out.println("\nХанойские башни Рекурсия");
        makeTowersRec(3, 1, 2, 3);
        System.out.println("\nХанойские башни Цикл");
        makeTowers(3);

    }

    public static int expRec(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b % 2 == 1) {
            return expRec(a, b - 1) * a;
        } else {
            int n = expRec(a, b / 2);
            return n * n;
        }
    }


    public static int exp(int a, int b) {
        int res = a;
        while (b > 1) {
            res *= a;
            b--;
        }
        return res;
    }

    //2. Познакомиться с головоломкой Ханойские башни.
    // Реализовать рекурсивный и циклический алгоритмы решения этой головоломки.

    public static void makeTowersRec(int top, int from, int middle, int to) {
        if (top == 1) System.out.println("Диск 1 перемещён с башни " + from + " на башню " + to );
        else {
            makeTowersRec(top - 1, from, to, middle);
            System.out.println("Диск " + top + " перемещён с башни " + from + " на башню " + to );
            makeTowersRec(top - 1, middle, from, to);
        }
    }

    public static void makeTowers(int numDiscs) {
        long numMoves = expRec(2, numDiscs) - 1;
        int[] towers = { 1, 2, 3, 1, 3, 2 };
        int count = 0;

        for (int currMove = 1; currMove <= numMoves; currMove++) {
            int disc = 0;
            while ( (currMove >> disc & 1) == 0 ) {
                disc++;
            }
            int level = (numDiscs - disc) & 1;
            int from = (currMove >> ++disc) % 3;
            from = towers[from + (level * 3)];
            int to = (from + level) % 3 + 1 ;
            System.out.println (++count + ". Диск " + disc + " перемещён с башни " + from  + " на башню " + to) ;
        }
    }
}
