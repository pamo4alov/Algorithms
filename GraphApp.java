package HW_7;

/*
    1.	Реализовать программу, в которой задается граф из 10 вершин.
    Задать ребра и найти кратчайший путь с помощью поиска в ширину.
    Выполнено на базе кода из методички.
*/

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');


        graph.addEdge(0, 1); //AB
        graph.addEdge(0, 2); //AC
        graph.addEdge(0, 3); //AD
        graph.addEdge(0, 4); //AE
        graph.addEdge(1, 5); //BF
        graph.addEdge(2, 6); //CG
        graph.addEdge(3, 8); //DI
        graph.addEdge(4, 9); //EJ
        graph.addEdge(5, 7); //FH
        graph.addEdge(6, 8); //GI
        graph.addEdge(7, 8); //HI

        graph.bfsBig(0,8);
    }

}
