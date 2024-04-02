package Assignment3;

import java.util.Scanner;

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
        } 
        else {
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
        } 
        else {
            Node parent = findNode(root, parentName);
            if (parent != null) {
                parent.addChild(newNode);
            } 
            else {
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
public class TreeOfHierarchy {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int userChoice;
        Tree tree = new Tree();

        tree.insert("Food", null);
        tree.insert("Consumable", "Food");
        tree.insert("Fruit", "Consumable");
        tree.insert("Vegetable", "Consumable");
        tree.insert("Meat", "Consumable");
        tree.insert("Dairy Product", "Consumable");
        tree.insert("Condiments", "Consumable");
        tree.insert("Beverage", "Consumable");

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
        tree.insert("Rice", "Vegetable");

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
        
		do {
			System.out.println("\nChoose a method to display the result:");
			System.out.println("1 - Display Tree of Hierarchy");
			System.out.println("2 - Display Bullet Form");
			System.out.println("3 - EXIT");
			System.out.println("Enter your choice: ");
			userChoice = userInput.nextInt();
			
			switch (userChoice) {
				case 1:
					System.out.println("\nTree of hierarchy:");
					tree.display(true);
					break;
				case 2:
					System.out.println("\nBullet Form:");
					tree.display(false);
					break;
				case 3:
					System.out.println("\nExiting Program.");
					System.exit(0);
				default:
					System.out.println("\nInvalid choice. Please enter a valid option.");
			}
		}while(userChoice != 3);
		
		userInput.close();
	}
}
