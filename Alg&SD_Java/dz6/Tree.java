package ru.geekbrains.Alg_SD.dz.dz6;

import java.util.Stack;

public class Tree implements TreeIF{

    private Node root; // корневой узел дерева
    private int size; // размер дерева
    private int levelTree; // уровень дерева
    private boolean isBalans; // показатель сбалансированности дерева

    public Tree() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public void add(int value) {
        Node node = new Node(value);

        if (root == null) {
            node.setLevel(1);
            root = node;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (value < current.getKey()) {
                current = current.getLeftChild();
                if (current == null) {
                    node.setLevel(parent.getLevel()+1);
                    parent.setLeftChild(node);
                    size++;
                    return;
                }
            } else {
                current = current.getRightChild();
                if (current == null) {
                    node.setLevel(parent.getLevel()+1);
                    parent.setRightChild(node);
                    size++;
                    return;
                }
            }
        }
}

    @Override
    public int remove(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null)
                return 0;
        }

        // Если у удаляемого узла нет потомков

        if (current.getLeftChild() == null && current.getRightChild() == null) {
           if (current == root) {
               root = null;
           } else if (isLeftChild){
               parent.setLeftChild(null);
           } else {
               parent.setRightChild(null);
           }
        }

        // Если у удаляемого узла нет правого потомка
        else  if (current.getRightChild() == null) {
            if (current == null) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
            levelUp (current);
        }

        // Если у удаляемого узла нет левого потомка
        else  if (current.getLeftChild() == null) {
            if (current == null) {
                root = current.getRightChild();
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
            levelUp (current);
        }

        // Если есть оба потомка
        else {
            Node succesor = getSuccesor(current);
            int level = current.getLevel();
            succesor.setLevel(level);
            if (current == root) {
                root = succesor;
            } else if (isLeftChild) {
                parent.setLeftChild(succesor);
            } else {
                parent.setRightChild(succesor);
            }
            succesor.setLeftChild(current.getLeftChild());
        }
        size--;
        levelTree(root, false);
        return current.getData();
    }

    private Node getSuccesor (Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRightChild();

        while (current!=null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }

    @Override
    public int find(int key) {
        Node current = root;

        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

            if (current == null)
                return 0;
        }
        return current.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void display() {
        Stack <Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack <Node> localStack = new Stack();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    // вывод узла с указанием значения
//                    System.out.print(tempNode.getKey());
                    // вывод узла с указанием уровня и значения
                    System.out.print(tempNode.getLevel() + " - " + tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Неизвестный режим обхода: " + mode);
        }
    }

    private void inOrder (Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.getLeftChild());
            rootNode.display();
            inOrder(rootNode.getRightChild());
        }
    }

    private void preOrder (Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            inOrder(rootNode.getLeftChild());
            inOrder(rootNode.getRightChild());
        }
    }

    private void postOrder (Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.getLeftChild());
            inOrder(rootNode.getRightChild());
            rootNode.display();
        }
    }

    public int getLevelTree() {
        levelTree(root, false);
        return levelTree;
    }

    private void levelTree (Node rootNode, boolean in) {
        if (!in) levelTree = 0;
        if (rootNode != null) {
        levelTree(rootNode.getLeftChild(), true);
        levelTree(rootNode.getRightChild(), true);
        if (rootNode.getLevel() > levelTree)
            levelTree = rootNode.getLevel();
        }
    }

    public boolean isTreeBalanced () {
        isBalans = true;
        levelTree(root, false);
        return isBalance(root);
    }

    private boolean isBalance (Node rootNode) {
        if (rootNode != null) {
            isBalance(rootNode.getLeftChild());
            isBalance(rootNode.getRightChild());
            if (rootNode.isLeaf() & (rootNode.getLevel() < levelTree -1))
                isBalans = false;
        }
        return isBalans;
    }

    private void levelUp (Node rootNode) {
        if (rootNode != null) {
            levelUp(rootNode.getLeftChild());
            levelUp(rootNode.getRightChild());
            rootNode.setLevel(rootNode.getLevel()-1);
        }
    }


}
