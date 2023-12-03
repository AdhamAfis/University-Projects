package com.company;

import java.util.LinkedList;
import java.util.Queue;

//Adham Ayman Farouk Ibrahim             21100782
public class SortQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(4);
		queue.add(6);
		queue.add(2);
		queue.add(9);
		System.out.println(queue);
		sortQueue(queue);
		System.out.println(queue);

	}

	public static void sortQueue(Queue<Integer> queue) {
		for (int i = 0; i <= queue.size(); i++) {
			int index = findMinIndex(queue, queue.size() - i);
			insertLast(queue, index);
		}
	}

	public static int findMinIndex(Queue<Integer> queue, int index) {
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int temp = queue.peek();
			queue.poll();
			if (temp <= min && i <= index) {
				minIndex = i;
				min = temp;
			}
			queue.add(temp);
		}
		return minIndex;
	}


	public static void insertLast(Queue<Integer> queue, int index) {
		int min = 0;
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int element_at_front = queue.peek();
			queue.poll();
			if (i != index) queue.add(element_at_front);
			else min = element_at_front;
		}
		queue.add(min);
	}


}

