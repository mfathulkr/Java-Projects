//-----------------------------------------------------
// Title: PlayerDatabase class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 03
// Description: This class have the main algorithm to manage the data. The class uses binary search tree structure while it is storing the data.
// Also it uses array list structure to manipulate the data when its needed.
//-----------------------------------------------------

import java.util.ArrayList;

public class PlayerDatabase {

	// --------------------------------------------------------
	// Summary: In this class we have 6 main method just like asked in the Q1. But also we have helper methods to manipulate the in needed parameters 
	// or to use the recursion in some cases.
	// --------------------------------------------------------
	
	
	private class Node {
		private Node left, right;
		private String name, surname;
		private int fee;

		public Node(String name, String sur, int fee) {
			this.fee = fee;
			this.name = name;
			this.surname = sur;
		}
	}

	//We have node inner class in private for our database
	private Node root;

	
	//We have  the array lists that i mentioned 
	ArrayList<String> players = new ArrayList<String>();
	ArrayList<Integer> fees = new ArrayList<Integer>();

	// we have the simple constructor
	public PlayerDatabase() {

		this.root = null;
	}

	
	// Here, insert method for out bst. 
	public void addPlayer(String name, String surname, int fee) {

		String p = name + surname + fee;
		players.add(p);
		fees.add(fee);
		Node node = new Node(name, surname, fee);

		root = addHelper(root, node);

	}
	
	//It has a helper class to  use the recursion just like i mentioned.
	public Node addHelper(Node root, Node node) {

		if (root == null) {
			root = node;
			return root;
		} else if (node.fee < root.fee) {
			root.left = addHelper(root.left, node);
		} else if (node.fee < root.fee) {
			root.right = addHelper(root.right, node);
		}
		return root;
	}
	
	//Here, remove method removes the elements of the array lists and 
	//calls the helper method to deal with removing the node in bst.
	public void removePlayer(String name, String surname) {

		String player = name + surname;

		if (searchByName(name, surname) == false) {
			return;
		}

		int fee = 0;// We must take care of the tree structure while we are removing the node with
					// that fee so we need this value. We will get this value from the fees array
					// list.

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).equalsIgnoreCase(player)) {
				players.remove(i);
				fee = fees.get(i);
				fees.remove(i);
			}
		}

		root = removeHelper(root, fee);

	}
	
	//Helper method does the job in recursive way when removing the node and replacing it with child node.
	private Node removeHelper(Node node, int fee) {

		if (node == null) {
			return node;
		}
		if (fee < node.fee) {
			node.left = removeHelper(node.left, fee);
		} else if (fee > node.fee) {
			node.right = removeHelper(node.right, fee);
		} else {
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
		}
		
		node.fee = minValue(node.right);

		node.right = removeHelper(node.right, node.fee);
		
		return node;
	}
	
	//This method help us to find min value in the bst
	private int minValue(Node root) {
		int minv = root.fee;
		while (root.left != null) {
			minv = root.left.fee;
			root = root.left;
		}
		return minv;
	}

	//Here, search method makes a search taking advantage of the array list for the names 
	public boolean searchByName(String name, String surname) {

		String player = name + surname;

		boolean res = false;

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).equalsIgnoreCase(player)) {
				res = true;
			}
		}

		if (res) {
			System.out.println("True!");
		} else {
			System.out.println("False!");
		}

		return res;

	}

	//Here, searchByRange method calls the helper method
	public void searchByRange(int min, int max) {

		rangeHelper(root, min, max);

	}

	//Helper method finds and prints needed information in recursive way again
	private void rangeHelper(Node node, int k1, int k2) {

		if (node == null) {
			return;
		}

		if (k1 < node.fee) {
			rangeHelper(node.left, k1, k2);
		}

		if (k1 < node.fee && k2 > node.fee) {
			System.out.print(node.name + " " + node.surname + " " + node.fee);
		}

		rangeHelper(node.right, k1, k2);

	}

	//Here print method calls its helper
	public void printAllPlayers() {

		printHelper(root);

	}

	//Here, helper method prints the data while reaching nodes of the tree in recursive way.
	private void printHelper(Node root) {

		if (root != null) {
			printHelper(root.left);
			System.out.println(root.name + " " + root.surname + " " + root.fee);
			printHelper(root.left);
		}

	}

	
	//This class the its helper method when it found the demanded node prints informations of the node
	public void findKSmallest(int k) {

		Node n = smallHelper(root, k);

		System.out.println(n.name + " " + n.surname);

	}

	//We got a count variable to help us the count while we using recursion
	int count = 0;

	//Here, helper class takes our root also goes deep in tree to find smallest while doing it counts for each floor it lands
	private Node smallHelper(Node root, int k) {

		if (root == null)
			return null;

		Node left = smallHelper(root.left, k);

		if (left != null)
			return left;

		count++;
		if (count == k)
			return root;

		return smallHelper(root.right, k);

	}

}
