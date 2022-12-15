package co.edu.uptc.model.structures;

/**
 * 
 * @author Daniel Torres
 * @Date 20/10/2022
 * @Description Node Class
 * @param <T>
 */

public class Node<T> {

	/**
	 * Attribute declaration
	 */

	protected T value;
	protected int height;
	protected Node<T> left;
	protected Node<T> right;

	/**
	 * Constructor method
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