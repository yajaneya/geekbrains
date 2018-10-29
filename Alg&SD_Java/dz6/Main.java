package ru.geekbrains.Alg_SD.dz.dz6;

public class Main {

    private static Tree [] trees = new Tree[20];

    public static void main(String[] args) {


        // метод создает и заполняет деревья, а также анализирует процент сбалансированности
        // после создания и заполнения выводит дерево в консоль, указывая на его сбалансированность
        // на последок выводит процент несбалансированных деревьев из всех созданных и заполненных
        // аргументы: Количество деревьев, количество уровней дерева, максимальное значение узла (модуль)
        trees (20, 6, 100);

        // модуль тестирует класс Tree
                testTree();

    }

    public static void trees(int numTrees, int numLevels, int maxKey) {

        int numUnBalancedTrees = 0;

        for (int i=0; i<numTrees; i++) {
            trees[i] = new Tree();
            while (trees[i].getLevelTree()<numLevels) {
                trees[i].add((int)(Math.random()*maxKey)*(Math.random()>0.5 ? -1 : 1));
            }

            System.out.println("Дерево № " + i + " - " + ((trees[i].isTreeBalanced()) ? "сбалансировано" : "несбалансировано"));
            numUnBalancedTrees += trees[i].isTreeBalanced() ? 0 : 1;
            trees[i].display();
        }
        System.out.println();
        System.out.println("Несбалансированных деревьев - " + (numUnBalancedTrees*100)/numTrees + "%");
    }

    public static void testTree() {

        Tree tree = new Tree();
        tree.add(60);
        tree.add(69);
        tree.add(23);
        tree.add(25);
        tree.add(67);
        tree.add(65);
        tree.add(64);
        tree.add(27);
        tree.add(63);
        tree.add(61);

        tree.display();
        System.out.println("Уровень дерева: " + tree.getLevelTree());
        System.out.println("Балансированность: " + tree.isTreeBalanced());

        System.out.println();
        System.out.println("Вывод в порядке сортировки:");
        tree.traverse(TraverseMode.IN_ORDER);
        System.out.println();
        System.out.println("Вывод в порядке пресортировки:");
        tree.traverse(TraverseMode.PRE_ORDER);
        System.out.println();
        System.out.println("Вывод в порядке постсортировки:");
        tree.traverse(TraverseMode.POST_ORDER);
        System.out.println();

        System.out.println("Поиск:");
        System.out.println("Ищем 23-го: " + tree.find(23));
        System.out.println("Ищем 60-го: " + tree.find(60));
        System.out.println("Ищем 67-го: " + tree.find(67));
        System.out.println("Ищем 111-го: " + tree.find(111));
        System.out.println();

        System.out.println("Удален из дерева: " + tree.remove(60));;
        System.out.println();
        tree.display();

        System.out.println("Удален из дерева: " + tree.remove(64));;
        System.out.println();
        tree.display();

    }
}
