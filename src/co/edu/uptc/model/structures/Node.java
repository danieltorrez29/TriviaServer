package co.edu.uptc.model.structures;

/**
 * 
 * Node class
 * 
 * @author Daniel Torres
 * @param <T>
 */

public class Node<T> {

	/**
	 * Generic value
	 */

	protected T value;

	/**
	 * Height
	 */

	protected int height;

	/**
	 * Left node
	 */

	protected Node<T> left;

	/**
	 * Right node
	 */

	protected Node<T> right;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param value
	 */

	public Node(T value) {
		this.value = value;
		height = 1;
		left = null;
		right = null;
	}

	/**
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Node [ value = " + value);
		if (left != null)
			info.append(" | left = " + left.toString());
		if (right != null) {
			info.append(" | right = " + right.toString());
		}
		info.append(" ]");
		return info.toString();
	}
}