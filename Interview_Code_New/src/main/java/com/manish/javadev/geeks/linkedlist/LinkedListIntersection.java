package com.manish.javadev.geeks.linkedlist;

public class LinkedListIntersection {
	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	private Node getNode() {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return getIntersectionNode(d, head1, head2);
		} else {
			d = c2 - c1;
			return getIntersectionNode(d, head2, head1);
		}
	}

	/*
	 * function to get the intersection point of two linked lists head1 and
	 * head2 where head1 has d more nodes than head2
	 */
	private Node getIntersectionNode(int d, Node node1, Node node2) {
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for (i = 0; i < d && current1 != null; i++) {
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return null;
	}

	/*
	 * Takes head pointer of the linked list and returns the count of nodes in
	 * the list
	 */
	int getCount(Node node) {
		Node current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public static void main(String[] args) {
		LinkedListIntersection list = new LinkedListIntersection();

		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(20);
		list.head1.next.next.next.next.next = new Node(30);
		list.head1.next.next.next.next.next.next = new Node(40);

		// creating second linked list
		list.head2 = new Node(6);
		list.head2.next = new Node(7);
		list.head2.next.next = new Node(20);
		list.head2.next.next.next = new Node(30);
		list.head2.next.next.next.next = new Node(40);

		System.out.println("The node of intersection is " + list.getNode().data);

	}

}
