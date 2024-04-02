import java.util.*;

class Node {
    private String name;
    private Node parent;
    private Node leftChild;
    private Node rightSibling;

    public Node(String name) {
        this.name = name;
    }

    // Getters and setters

    public void addChild(Node child) {
        if (leftChild == null) {
            leftChild = child;
        } else {
            Node sibling = leftChild;
            while (sibling.rightSibling != null) {
                sibling = sibling.rightSibling;
            }
            sibling.rightSibling = child;
        }
        child.parent = this;
    }

    public void display(int level, boolean asciiMode) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < level; i++) {
            prefix.append("  ");
        }
        System.out.println(prefix + (asciiMode ? "└─ " : "- ") + name);
        Node child = leftChild;
        while (child != null) {
            child.display(level + 1, asciiMode);
            child = child.rightSibling;
        }
    }
}

class Tree {
    private Node root;

    public void insert(String name, String parentName) {
        Node newNode = new Node(name);
        if (parentName == null) {
            root = newNode;
        } else {
            Node parent = findNode(root, parentName);
            if (parent != null) {
                parent.addChild(newNode);
            } else {
                System.out.println("Parent node not found.");
            }
        }
    }

    private Node findNode(Node current, String name) {
        if (current == null) {
            return null;
        }
        if (current.getName().equals(name)) {
            return current;
        }
        Node foundNode = findNode(current.leftChild, name);
        if (foundNode == null) {
            foundNode = findNode(current.rightSibling, name);
        }
        return foundNode;
    }

    public void display(boolean asciiMode) {
        if (root != null) {
            root.display(0, asciiMode);
        }
    }
}
