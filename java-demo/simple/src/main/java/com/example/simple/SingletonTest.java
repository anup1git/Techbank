package com.example.simple;

import java.io.Serializable;

enum Singleton implements Serializable, Cloneable {
	
	INSTANCE;

	private int number;

	Singleton() {
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}

class SingletonClass implements Serializable, Cloneable {

	private static SingletonClass INSTANCE;
	private int number;

	SingletonClass() {

	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	private static final class SingletonHolder {
		private static final SingletonClass singletonClass = new SingletonClass();
	}

	public static SingletonClass getInstance() {
		return SingletonHolder.singletonClass;
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		synchronizedTest();
		reflectionTest();
	}

	private static void reflectionTest() {
		// TODO Auto-generated method stub

	}

	public static void synchronizedTest() {
		Singleton singleton = Singleton.INSTANCE;
		singleton.getNumber();

		// Reflection

		Runnable getSingleton = () -> {
			Singleton singleton1 = Singleton.INSTANCE;
			System.out.println(System.identityHashCode(singleton1));
		};

		Thread thread1 = new Thread(getSingleton);
		Thread thread2 = new Thread(getSingleton);
		Thread thread3 = new Thread(getSingleton);

		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("Without Enum");
		// Reflection

		Runnable getSingletonClass = () -> {
			SingletonClass singleton1 = SingletonClass.getInstance();
			System.out.println(System.identityHashCode(singleton1));
		};

		Thread thread4 = new Thread(getSingletonClass);
		Thread thread5 = new Thread(getSingletonClass);
		Thread thread6 = new Thread(getSingletonClass);

		thread4.start();
		thread5.start();
		thread6.start();
	}

}
