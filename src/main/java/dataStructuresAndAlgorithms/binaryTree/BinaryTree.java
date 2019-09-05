package dataStructuresAndAlgorithms.binaryTree;

public class BinaryTree {
	
	Node root;
	
	public static void main(String arg[]) {
		BinaryTree binaryTree = new BinaryTree();
		/*
		binaryTree.addNode(0, "Zero");
		binaryTree.addNode(1, "One");
		binaryTree.addNode(2, "Two");
		binaryTree.addNode(3, "Three");
		binaryTree.addNode(4, "Four");
		binaryTree.addNode(5, "Five");
		*/
		
		binaryTree.addNode(50,"Boss");
		binaryTree.addNode(25,"Vice Pres");
		binaryTree.addNode(15,"Office Manager");
		binaryTree.addNode(30,"Secretary");
		binaryTree.addNode(75,"Sales Manager");
		binaryTree.addNode(85,"Sales Man1");
		
		inOrderTraversal(binaryTree.root);
		System.out.println();
		preOrderTraversal(binaryTree.root);
		System.out.println();
		postOrderTraversal(binaryTree.root);
	}
	
	private void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if(root == null) {
			root = newNode;
		}else {
			Node focusNode = root;
			Node parent;
			while(true) {
				parent = focusNode;
				if(key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}else {
					focusNode = focusNode.rightChild;
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public static void inOrderTraversal(Node node) {
		if(node.leftChild != null) {
			inOrderTraversal(node.leftChild);
		}
		System.out.println(node);
		if(node.rightChild != null) {
			inOrderTraversal(node.rightChild);
		}
	}
	
	public static void preOrderTraversal(Node node) {
		System.out.println(node);
		if(node.leftChild != null) {
			inOrderTraversal(node.leftChild);
		}
		if(node.rightChild != null) {
			inOrderTraversal(node.rightChild);
		}
	}
	
	public static void postOrderTraversal(Node node) {
		if(node.leftChild != null) {
			inOrderTraversal(node.leftChild);
		}
		if(node.rightChild != null) {
			inOrderTraversal(node.rightChild);
		}
		System.out.println(node);
	}
}

class Node{
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	Node(int key){
		this.key = key;
	}
	
	public String toString() {
		return name + " has a key  " + key;
	}
	
}