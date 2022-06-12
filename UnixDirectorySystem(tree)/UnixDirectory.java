//-----------------------------------------------------
// Title: GUI class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 03
// Description: This class is for our data structure and managing algorithms of data.
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class UnixDirectory {

	// Here we have huge node class to easily manage the nodes and their informations.
	// It contains an array list for the children of each node in order to have children
	// as much as demanded.
	private class Node {
	    private List<Node> children;
	    private Node parent;
	    private String name;
	    private int size;
	    private int depth;

	    public Node(String name, int size) {
	        // a fresh node, without a parent reference
	        this.children = new ArrayList<>();
	        this.parent = null;
	        this.name = name;
	        this.size = size;
	        this.depth=0;
	    }

	    public Node(String name, int size, Node parent) {
	        // new node with a given parent
	        this.children = new ArrayList<>();
	        this.name = name;
	        this.size = size;
	        this.parent = parent;
	        this.depth = (parent.getDepth() + 1);
	        parent.addChild(this);
	    }

	    public int getDepth() {
	        return this.depth;
	    }

	    public void setDepth(int depth) {
	        this.depth = depth;
	    }

	    public List<Node> getChildren() {
	        return children;
	    }

	    public void setParent(Node parent) {
	        this.setDepth(parent.getDepth() + 1);
	        parent.addChild(this);
	        this.parent = parent;
	    }

	    public Node getParent() {
	        return this.parent;
	    }

	    public void addChild(String name, int size) {
	        Node child = new Node(name, size);
	        this.children.add(child);
	    }

	    public void addChild(Node child) {
	        this.children.add(child);
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setname(String name) {
	        this.name = name;
	    }
	    public int getSize() {
	        return this.size;
	    }

	    public void setSize(int size) {
	        this.size = size;
	    }

	    public boolean isRootNode() {
	        return (this.parent == null);
	    }

	    public boolean isLeafNode() {
	        return (this.children.size() == 0);
	    }

	    public void removeParent() {
	        this.parent = null;
	    }
	    public void removeChildren() {
	    	this.children =null;
	    }


	}
	
	
	private Node root = null;
	// Here basic constructor
	public UnixDirectory () {
		this.root = null;
	}

	//This method creates directories. It has base cases and a recursive part to find the given parent.
	public void createDirectory(String parent, String child, int psize, int csize) {

		if(root == null) {
			Node root = new Node(parent, psize);
			Node nodeChild = new Node(child, csize, root);
		}
		else {
			List <Node> childrens = root.getChildren();
			Node p =new Node(parent, psize);
			for(int i= 0; i<childrens.size(); i++) {
				if(childrens.get(i).name.equalsIgnoreCase(parent) && childrens.get(i).size ==psize) {
					Node nodeChild =new Node (child, csize, childrens.get(i));
					return;
				}
			}
			for(int i = 0; i < root.children.size();i++) {
				createDirectory(root.children.get(i).name, child, root.children.get(i).size, csize);
			}
		}
		
		
	}

	//This remove method has an helper
	public void removeDirectory(String dirName) {
		
		removeHelper(root, dirName);
		
	}
	
	// in extra helper method has the root.
	// and its again has base cases and recursive part in order to track the demanded node
	// recursive part removes the children of that node
	private void removeHelper(Node root, String dirName) {
		if(root == null) {
			return;
		}else {
			for(int i = 0; i < root.children.size(); i++) {
				if(root.children.get(i).name.equalsIgnoreCase(dirName)) {
					root.children.get(i).removeChildren();
					root.children.get(i).removeParent();
					return;
				}
			}
			for(int i = 0; i < root.children.size(); i++) {
				removeHelper(root.children.get(i), dirName);
			}
		}
		
	}

	// this one has an helper method
	public void listDirectory(String dirName) {
		listHelper(root, dirName);
	}
	
	// helper method takes the root as a parameter in extra
	// it has 2 base cases one of them for no root other is the returning case of the recursive part
	private void listHelper(Node root, String dirName) {
		
		if(root == null) {
			return;
		}else {
			
			if(root.name.equalsIgnoreCase(dirName)) {
				for(int i = 0; i < root.children.size(); i++) {
					System.out.println(root.children.get(i).name + " ");
				}
				return;
			}
			for(int i = 0; i < root.children.size(); i++) {
				if(root.children.get(i).name.equalsIgnoreCase(dirName)) {
					for(int j = 0; j < root.children.get(i).children.size(); j++) {
						System.out.println(root.children.get(i).children.get(j).name + " ");
					}
				}
			}
			for(int i = 0; i < root.children.size(); i++) {
				listHelper(root.children.get(i), dirName);
			}
		}
		
	}

	// This one has an helper method and a print statement for final
	public void listDirectorySize(String dirName) {
		int total =sizeListHelper(root, dirName);
		
		System.out.println(total);
	}

	//this method finds the demanded node to add them up
	private int sizeListHelper(Node root, String dirName) {
		
		int res = 0;
		
		if(root == null) {
			return res;
		}else {
			
			for(int i = 0; i < root.children.size(); i++) {
				
				Node n = root.children.get(i);
				
				if(n.name.equalsIgnoreCase(dirName)) {
					res = sumOfRootAndChilds(n);
					
					return res;
				}
				
				sizeListHelper(n, dirName);
				
			}
			
			
			
			return res;
		}
		
		
	}
	// this method finally adding the size of root
	private int sumOfRootAndChilds(Node n) {
		
		if(n == null) {
			return 0;
		}
		
		int sum  = n.size;
		int csum = 0;
		for(int i = 0; i < n.children.size(); i++) {
			
			Node child = n.children.get(i);
			csum = childsum(child);
		}		
		
		
		return sum + csum;
	}
	
	// this method for add the child of child of child ...
	// has a base case
	private int childsum(Node child) {
		
		if(child.children.size() == 0) {
			return 0;
		}
		else {
			
			int sum = 0;
			
			for(int i = 0; i <child.children.size(); i++) {
				sum = child.children.get(i).size + childsum(child.children.get(i));
			}
			
			return sum;
			
		}
		
		
	}
}
