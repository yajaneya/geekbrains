package ru.geekbrains.Alg_SD.dz.dz7;

public class Main {
    private static Graph graph;

    public static void main(String[] args) {

        graphInit();
        System.out.println("Связи графа: ");
        System.out.println("---------------------------");
        graph.display();
        System.out.println();

        System.out.println("Обход в глубину: ");
        System.out.println("---------------------------");
        graph.dfs();
        System.out.println();

        System.out.println("Обход в ширину: ");
        System.out.println("---------------------------");
        graph.bfs();
        System.out.println();

        System.out.println("Поиск кратчайшего пути: ");
        System.out.println("---------------------------");
        graph.findShotWay(0,9);
        System.out.println();

    }

    private static void graphInit() {

        graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);
        graph.addEdge(4,9);
        graph.addEdge(7,9);
        graph.addEdge(8,9);

    }
}
