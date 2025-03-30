import java.util.*;

public class BST<E extends Comparable<E>> implements Tree<E> {
	protected TreeNode<E> root;
	protected int size = 0;
	protected java.util.Comparator<E> comparator = null;

	/** Create a default binary tree */
	public BST() {
	}

	/** Create a binary tree with a specified comparator */
	public BST(java.util.Comparator<E> comparator) {
		this.comparator = comparator;
	}

	/** Create a binary tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Compare two elements */
	protected int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		} else {
			return e1.compareTo(e2);
		}
	}

	@Override /** Returns true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (compare(e, current.element) < 0) {
				current = current.left;
			} else if (compare(e, current.element) > 0) {
				current = current.right;
			} else // element matches current.element
				return true; // Element is found
		}

		return false;
	}

	@Override /**
	 * Insert element o into the binary tree Return true if the
	 * element is inserted successfully
	 */
	public boolean insert(E e) {

		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null)
				if (compare(e, current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (compare(e, current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted

			// Create the new node and attach it to the parent node
			if (compare(e, parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}

		size++;
		return true; // Element inserted successfully
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}

	@Override /** Inorder traversal from the root */
	public ArrayList<E> inorder() {
		ArrayList<E> inorderList = new ArrayList<>();
		inorder(root, inorderList);
		return inorderList;
	}

	/**
	 * Inorder traversal from a subtree
	 *
	 * @return
	 */
	protected ArrayList<E> inorder(TreeNode<E> root, ArrayList<E> list) {
		if (root == null)
			return list;
		inorder(root.left, list);
		list.add(root.element);
		return inorder(root.right, list);
	}

	@Override /** Postorder traversal from the root */
	public ArrayList<E> postorder() {
		ArrayList<E> postorderList = new ArrayList<>();
		postorder(root, postorderList);
		return postorderList;
	}

	/**
	 * Postorder traversal from a subtree
	 *
	 * @return
	 */
	protected ArrayList<E> postorder(TreeNode<E> root, ArrayList<E> list) {
		if (root == null)
			return list;
		postorder(root.left, list);
		postorder(root.right, list);
		list.add(root.element);
		return list;
	}

	@Override /** Preorder traversal from the root */
	public ArrayList<E> preorder() {
		ArrayList<E> postorderList = new ArrayList<>();
		preorder(root, postorderList);
		return postorderList;
	}

	/**
	 * Preorder traversal from a subtree
	 *
	 * @return
	 */
	protected ArrayList<E> preorder(TreeNode<E> root, ArrayList<E> list) {
		if (root == null)
			return list;
		list.add(root.element);
		preorder(root.left, list);
		return preorder(root.right, list);
	}

	/**
	 * This inner class is static, because it does not access any instance
	 * members defined in its outer class
	 */
	public static class TreeNode<E> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public ArrayList<TreeNode<E>> path(E e) {
		ArrayList<TreeNode<E>> list = new ArrayList<>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (compare(e, current.element) < 0) {
				current = current.left;
			} else if (compare(e, current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array list of nodes
	}

	@Override /**
	 * Delete an element from the binary tree. Return true if the
	 * element is deleted successfully Return false if the element
	 * is not in the tree
	 */
	public boolean delete(E e) {
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (compare(e, current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (compare(e, current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (compare(e, parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}

	@Override /** Obtain an iterator. Use inorder. */
	public Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements Iterator<E> {
		// Store the elements in a list
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0; // Point to the current element in list
		private boolean canRemove = false;

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get the current element and move to the next */
		public E next() {
			if (hasNext())
				canRemove = true;
			else
				throw new NoSuchElementException();
			return list.get(current++);
		}

		@Override /** Remove the current element */
		public void remove() {
			if (!canRemove)
				throw new IllegalStateException();
			else {
				delete(list.get(current-- - 1));
				canRemove = false;
			}
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}

	@Override /** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}

	public List<E> inorderList() {
		List<E> list = new ArrayList<E>();
		inorderList(root, list);
		return list;
	}

	private void inorderList(TreeNode<E> root, List<E> list) {
		if (root != null) {
			inorderList(root.left, list);
			list.add(root.element);
			inorderList(root.right, list);
		}
	}

	public List<E> preorderList() {
		List<E> list = new ArrayList<E>();
		preorderList(root, list);
		return list;
	}

	private void preorderList(TreeNode<E> root, List<E> list) {
		if (root != null) {
			list.add(root.element);
			preorderList(root.left, list);
			preorderList(root.right, list);
		}
	}

	public List<E> postorderList() {
		List<E> list = new ArrayList<E>();
		postorderList(root, list);
		return list;
	}

	private void postorderList(TreeNode<E> root, List<E> list) {
		if (root != null) {
			postorderList(root.left, list);
			postorderList(root.right, list);
			list.add(root.element);
		}
	}

	public List<E> breadthFirstList() {
		ArrayList<E> list = new ArrayList<E>();
		Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
		if (root != null)
			queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<E> node = queue.remove();
			list.add(node.element);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return list;
	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode<E> root) {
		if (root == null)
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}