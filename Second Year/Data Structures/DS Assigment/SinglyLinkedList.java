package com.company;

//Adham Ayman Farouk Ibrahim             21100782
public class SinglyLinkedList {
	private Node head;
	private int size;

	public void insert(int x) {
		Node newNode = new Node(x);
		Node currentNode = head;
		if (head == null) {
			head = newNode;
			newNode.next = null;
			size = 1;
		} else {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
			newNode.next = null;
			size++;
		}
	}

	public void insertFirst(int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
		size++;

	}


	public void insertNth(int x, int index) {
		Node newNode = new Node(x);
		Node currentNode = head;

		if (head != null && index <= size) {
			for (int i = 1; i < index; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			size++;

		} else System.out.println("Index Out Of Bounds\t\t\tSize : " + size);
	}

	public void deleteFirst() {
		if (head != null) {
			head = head.next;
			size--;
		} else {
			System.out.println("Linked List Is Empty");
		}
	}

	public void deleteLastNode() {
		Node currentNode = head;
		if (size == 1) {
			head = null;
			size = 0;
		} else {
			Node prevNode = null;
			while (currentNode.next != null) {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			prevNode.next = null;
			size--;
		}
	}

	public void deleteNthNode(int index) {
		Node currentNode = head;
		Node prevNode = null;
		if (size >= index && head != null) {
			for (int i = 1; i < index; i++) {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			prevNode.next = currentNode.next;
			size--;
		} else {
			System.out.println("Node Doesn't Exist");
		}
	}

	public void findNode(int x) {
		Node currentNode = head;
		boolean found = false;
		int count = 0;
		while (currentNode != null) {
			count++;
			if (currentNode.data == x) {
				found = true;
				break;
			}
			currentNode = currentNode.next;
		}
		if (found) System.out.println(x + " Is At " + count);
		else System.out.println(x + " Doesn't Exist ");
	}

	public void findAt(int index) {
		Node currentNode = head;
		if (head != null && index <= size) {
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			System.out.println(currentNode.data);
		} else System.out.println("Node Doesn't Exist");
	}

	public void findMax() {
		Node currentNode = head;
		int max = currentNode.data;
		while (currentNode != null) {
			if (max <= currentNode.data) {
				max = currentNode.data;
			}
			currentNode = currentNode.next;
		}
		System.out.println("Max : " + max);
	}

	public void findMin() {
		Node currentNode = head;
		int min = currentNode.data;
		while (currentNode != null) {
			if (min >= currentNode.data) {
				min = currentNode.data;
			}
			currentNode = currentNode.next;
		}
		System.out.println("Min : " + min);
	}

	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public int getSize() {
		return size;
	}
}




