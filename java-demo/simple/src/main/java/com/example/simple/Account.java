package com.example.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Account {

	private void helloWorld() {
		System.out.println("Helo world");
	}

	public static void main(String[] args) {
		
		Account account = new Account();
		account.helloWorld();
		
		Runnable runnable = () -> {
			System.out.println("Runnable Helo world");
		};
		
		runnable.run();
		
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		
	}

	private void evenFilterSquare() {
		Scanner scanner = new Scanner(System.in);
//		Integer [] inputsIntegers = new Integer[];
		List<Integer> evenList = new ArrayList<Integer>();
	}

}
