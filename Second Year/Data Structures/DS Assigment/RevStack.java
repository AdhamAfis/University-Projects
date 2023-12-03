package com.company;

import java.util.Stack;

//Adham Ayman Farouk Ibrahim             21100782
public class RevStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);
	}

	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int temp = stack.pop();
		reverseStack(stack);
		insertLast(stack, temp);
	}

	public static void insertLast(Stack<Integer> stack, int num) {
		if (stack.isEmpty()) {
			stack.push(num);
			return;
		}
		int top = stack.pop();
		insertLast(stack, num);
		stack.push(top);
	}
}

