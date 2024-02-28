package co.edu.uptc.model.structures;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * AVLTree class
 * 
 * @author Daniel Torres
 * @param <T>
 */

public class AVLTree<T> {

	/**
	 * Root
	 */

	private Node<T> root;

	/**
	 * Comparator
	 */

	private Comparator<T> comparator;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param comparator
	 */

	public AVLTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	/**
	 * 
	 * height int method
	 * 
	 * @param root
	 * @return int
	 */

	private int height(Node<T> root) {
		return root == null ? 0 : root.height;
	}

	/**
	 * 
	 * max int method
	 * 
	 * @param a
	 * @param b
	 * @return int
	 */

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	/**
	 * 
	 * rightRotate Node<T> method
	 * 
	 * @param y
	 * @return Node<T>
	 */

	private Node<T> rightRotate(Node<T> y) {
		Node<T> x = y.left;
		Node<T> T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	/**
	 * 
	 * leftRotate Node<T> method
	 * 
	 * @param x
	 * @return Node<T>
	 */

	private Node<T> leftRotate(Node<T> x) {
		Node<T> y = x.right;
		Node<T> T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	/**
	 * 
	 * getBalance int method
	 * 
	 * @param N
	 * @return Node<T>
	 */

	private int getBalance(Node<T> N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	/**
	 * 
	 * insert void method
	 * 
	 * @param value
	 */

	public void insert(T value) {
		root = insertRecursive(root, value);
	}

	/**
	 * 
	 * insert Node<T> method
	 * 
	 * @param node
	 * @param value
	 * @return Node<T>
	 */

	private Node<T> insertRecursive(Node<T> node, T value) {

		/* 1. Perform the normal BST insertion */
		if (node == null)
			return (new Node<T>(value));

		if (comparator.compare(value, node.value) < 0)
			node.left = insertRecursive(node.left, value);
		else if (comparator.compare(value, node.value) > 0)
			node.right = insertRecursive(node.right, value);
		else // Duplicate values not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left), height(node.right));

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this node
		 * became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && comparator.compare(value, node.left.value) < 0)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && comparator.compare(value, node.right.value) > 0)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && comparator.compare(value, node.left.value) > 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && comparator.compare(value, node.right.value) < 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	/**
	 * 
	 * minValueNode Node<T> method
	 * 
	 * @param node
	 * @return Node<T>
	 */

	private Node<T> minValueNode(Node<T> node) {
		Node<T> current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;

		return current;
	}

	/**
	 * 
	 * delete void method
	 * 
	 * @param value
	 */

	public void delete(T value) {
		root = deleteRecursive(root, value);
	}

	/**
	 * 
	 * deleteRecursive Node<T> method
	 * 
	 * @param root
	 * @param value
	 * @return Node<T>
	 */

	private Node<T> deleteRecursive(Node<T> root, T value) {
		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null)
			return root;

		// If the key to be deleted is smaller than
		// the root's key, then it lies in left subtree
		if (comparator.compare(value, root.value) < 0)
			root.left = deleteRecursive(root.left, value);

		// If the key to be deleted is greater than the
		// root's key, then it lies in right subtree
		else if (comparator.compare(value, root.value) > 0)
			root.right = deleteRecursive(root.right, value);

		// if key is same as root's key, then this is the node
		// to be deleted
		else {

			// node with only one child or no child
			if ((root.left == null) || (root.right == null)) {
				Node<T> temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				// No child case
				if (temp == null) {
					temp = root;
					root = null;
				} else // One child case
					root = temp; // Copy the contents of
									// the non-empty child
			} else {

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				Node<T> temp = minValueNode(root.right);

				// Copy the inorder successor's data to this node
				root.value = temp.value;

				// Delete the inorder successor
				root.right = deleteRecursive(root.right, temp.value);
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = max(height(root.left), height(root.right)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	/**
	 * 
	 * search T method
	 * 
	 * @param value
	 * @return T
	 */

	public T search(T value) {
		Node<T> target = searchRecursive(root, value);
		return target != null ? target.value : null;
	}

	/**
	 * 
	 * search_Recursive Node<T> method
	 * 
	 * @param root
	 * @param value
	 * @return Node<T>
	 */

	private Node<T> searchRecursive(Node<T> root, T value) {
		if (root == null || comparator.compare(value, root.value) == 0)
			return root;
		else if (comparator.compare(value, root.value) < 0)
			return searchRecursive(root.left, value);
		return searchRecursive(root.right, value);
	}

	/**
	 * 
	 * exist boolean method
	 * 
	 * @param value
	 * @return boolean
	 */

	public boolean exist(T value) {
		return search(value) != null ? true : false;
	}

	/**
	 * 
	 * traverseInOrder ArrayList<T> method
	 * 
	 * @return ArrayList<T>
	 */

	public ArrayList<T> traverseInOrder() {
		ArrayList<T> values = new ArrayList<T>();
		return traverseInOrder(root, values);
	}

	/**
	 * 
	 * traverseInOrder ArrayList<T> method
	 * 
	 * @param root
	 * @param values
	 * @return ArrayList<T>
	 */

	private ArrayList<T> traverseInOrder(Node<T> root, ArrayList<T> values) {
		if (root != null) {
			traverseInOrder(root.left, values);
			values.add(root.value);
			traverseInOrder(root.right, values);
		}
		return values;
	}

	/**
	 * 
	 * traversePreOrder ArrayList<T> method
	 * 
	 * @return ArrayList<T>
	 */

	public ArrayList<T> traversePreOrder() {
		ArrayList<T> values = new ArrayList<T>();
		return traversePreOrder(root, values);
	}

	/**
	 * 
	 * traversePreOrder ArrayList<T> method
	 * 
	 * @param root
	 * @param values
	 * @return ArrayList<T>
	 */

	private ArrayList<T> traversePreOrder(Node<T> root, ArrayList<T> values) {
		if (root != null) {
			values.add(root.value);
			traversePreOrder(root.left, values);
			traversePreOrder(root.right, values);
		}
		return values;
	}

	/**
	 * 
	 * traversePostOrder ArrayList<T> method
	 * 
	 * @return ArrayList<T>
	 */

	public ArrayList<T> traversePostOrder() {
		ArrayList<T> values = new ArrayList<T>();
		return traversePostOrder(root, values);
	}

	/**
	 * 
	 * traversePostOrder ArrayList<T> method
	 * 
	 * @param root
	 * @param values
	 * @return ArrayList<T>
	 */

	private ArrayList<T> traversePostOrder(Node<T> root, ArrayList<T> values) {
		if (root != null) {
			traversePostOrder(root.left, values);
			traversePostOrder(root.right, values);
			values.add(root.value);
		}
		return values;
	}

	/**
	 * 
	 * getRandomValue T method
	 * 
	 * @return T
	 */

	public T getRandomValue() {
		ArrayList<T> values = traverseInOrder();
		return values.get((int) ((Math.random() * (values.size()))));
	}
}