package com.nikhilchadha.learning;

import java.util.HashSet;

public class ReverseLinkedList {

	public static void main(String[] args) {
	
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		printList(head);
		
		head = reverseList(head);
		
		printList(head);
		
		System.out.println("Loop Exists: " + detectLoop(head));
	}
	
	public static void printList(Node node) {
		System.out.println("Linked List Nodes In Order:");
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public static Node reverseList(Node head) {
		
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static boolean detectLoop(Node head) {
		
		HashSet<Node> nodeSet = new HashSet<>();
		
		while (head != null) {
			if (nodeSet.contains(head))
				return true;
			nodeSet.add(head);
			head = head.next;
		}
		
		return false;
	}
	
}

