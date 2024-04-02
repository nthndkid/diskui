class Node {
    private String name;
    private Node parent;
    private Node leftChild;
    private Node rightSibling;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightSibling() {
        return rightSibling;
    }

    public void setRightSibling(Node rightSibling) {
        this.rightSibling = rightSibling;
    }

    public void addChild(Node child) {
        if (leftChild == null) {
            leftChild = child;
        } else {
            Node sibling = leftChild;
            while (sibling.getRightSibling() != null) {
                sibling = sibling.getRightSibling();
            }
            sibling.setRightSibling(child);
        }
        child.setParent(this);
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
            child = child.getRightSibling();
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
        Node foundNode = findNode(current.getLeftChild(), name);
        if (foundNode == null) {
            foundNode = findNode(current.getRightSibling(), name);
        }
        return foundNode;
    }

    public void display(boolean asciiMode) {
        if (root != null) {
            root.display(0, asciiMode);
        }
    }
}
