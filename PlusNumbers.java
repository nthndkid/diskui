package numbers;

import java.util.Scanner;

class Node {
    private String name;
    private Node parent;
    private Node leftChild;
    private Node rightSibling;

    public Node(String name) {
        this.name = name;
        this.parent = null;
        this.leftChild = null;
        this.rightSibling = null;
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
}

class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(String name, String parentName) {
        Node newNode = new Node(name);
        if (parentName == null) {
            root = newNode;
        } else {
            Node parent = findNode(root, parentName);
            if (parent != null) {
                if (parent.getLeftChild() == null) {
                    parent.setLeftChild(newNode);
                } else {
                    Node sibling = parent.getLeftChild();
                    while (sibling.getRightSibling() != null) {
                        sibling = sibling.getRightSibling();
                    }
                    sibling.setRightSibling(newNode);
                }
                newNode.setParent(parent);
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

    public Node getRoot() {
        return root;
    }

    public void displayTree(Node node, int level, boolean asciiMode) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < level; i++) {
            prefix.append("  ");
        }

        if (asciiMode) {
            System.out.println(prefix.toString() + "└─ " + node.getName());
        } else {
            System.out.println(prefix.toString() + "- " + node.getName());
        }

        Node child = node.getLeftChild();
        while (child != null) {
            displayTree(child, level + 1, asciiMode);
            child = child.getRightSibling();
        }
    }
}

public class PlusNumbers{
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Tree tree = new Tree();

	        // Adding nodes to the tree based on the provided list
	        tree.insert("Food", null);
	        tree.insert("Consumable", "Food");
	        tree.insert("Fruit", "Food");
	        tree.insert("Vegetable", "Food");
	        tree.insert("Meat", "Food");
	        tree.insert("Dairy Product", "Food");
	        tree.insert("Condiments", "Food");
	        tree.insert("Beverage", "Food");

	        tree.insert("Apple", "Fruit");
	        tree.insert("Banana", "Fruit");
	        tree.insert("Grapes", "Fruit");
	        tree.insert("Orange Juice", "Beverage");
	        tree.insert("Milk", "Dairy Product");
	        tree.insert("Cheese", "Dairy Product");
	        tree.insert("Yoghurt Cream", "Dairy Product");
	        tree.insert("Butter", "Dairy Product");
	        tree.insert("Shake", "Beverage");
	        tree.insert("Cocoa", "Beverage");

	        tree.insert("Green Bean", "Vegetable");
	        tree.insert("Spinach", "Vegetable");
	        tree.insert("Carrots", "Vegetable");
	        tree.insert("Lettuce", "Vegetable");
	        tree.insert("Tomato", "Vegetable");
	        tree.insert("Rice", "Consumable");

	        tree.insert("Pork", "Meat");
	        tree.insert("Beef", "Meat");
	        tree.insert("Chicken", "Meat");
	        tree.insert("Poultry", "Meat");
	        tree.insert("Fish", "Meat");
	        tree.insert("Shrimp", "Meat");
	        tree.insert("Egg", "Meat");

	        tree.insert("Soy Sauce", "Condiments");
	        tree.insert("Fish Sauce", "Condiments");
	        tree.insert("Shrimp Paste", "Condiments");
	        tree.insert("Pineapple", "Fruit");

	        // Displaying the menu and interacting with the user
	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Display tree (ASCII)");
	            System.out.println("2. Display tree (Bullet form)");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.println("\nTree (ASCII):");
	                    tree.displayTree(tree.getRoot(), 0, true);
	                    break;
	                case 2:
	                    System.out.println("\nTree (Bullet form):");
	                    tree.displayTree(tree.getRoot(), 0, false);
	                    break;
	                case 3:
	                    System.out.println("Exiting program.");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }
}
