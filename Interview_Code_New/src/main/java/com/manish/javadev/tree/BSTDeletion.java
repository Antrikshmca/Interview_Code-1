package com.manish.javadev.tree;

public class BSTDeletion {
	static BSTNodeTest start;
	static BSTNodeTest current;

	public static void main(String[] args) {

		BSTNodeTest root = insert(current, 10);
		insert(root, 19);
		insert(root, 15);
		insert(root, 17);
		insert(root, 20);

		insert(root, 5);
		insert(root, 2);
		System.out.println("manishjavadev.com – Binary Tree Inorder Traversal");
		preOrder(root);
		delete(root, 19);
		System.out.println("manishjavadev.com – Binary Tree Inorder Traversal");
		preOrder(root);
	}

	public static void preOrder(BSTNodeTest root) {
		if (root != null) {
			System.out.print(root.data + "\t");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private static BSTNodeTest find(BSTNodeTest root, int data) {

		// This block for recursion
		if (root == null) {
			return current;
		}
		current = root;
		if (root.data == data) {
			return current;
		} else if (root.data < data) {
			return find(root.right, data);
		} else {
			return find(root.left, data);
		}
		// recursion end
	}

	private static BSTNodeTest insert(BSTNodeTest root, int data) {
		
		BSTNodeTest node = new BSTNodeTest();
		node.data = data;
		if (root == null) {
			return node;
		}
		current = find(root, data);

		if (current.data > data) {
			current.left = node;
		} else {
			current.right = node;
		}
		return root;
	}

	private static BSTNodeTest delete(BSTNodeTest root, int data) {
		start = root;
		BSTNodeTest end = null;
		while (start != null) {
			if (start.data == data) {
				break;
			}
			end = start;
			if (start.data > data) {
				start = start.left;
			} else {
				start = start.right;
			}
		}

		// Delete node has 2 child
		if (start.left != null && start.right != null) {
			BSTNodeTest y = start.left;
			end = start;
			while (y.right != null) {
				end = y;
				y = y.right;
			}
			start.data = y.data;
			start = y;
		}
		// Delete leaf or 1 child
		if (end == null) {
			if (start.left != null) {
				return start.left;
			} else {
				return start.right;
			}
		}
		if (end.right == start) {
			end.right = start.right;
		} else {
			end.left = start.left;
		}
		return root;
	}
}