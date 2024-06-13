package com.example.simple;

public class SimpleHashMap<K, V> {
	
	// Initial capacity of the bucket array
	private static final int CAPACITY = 16;

	// Array to store the linked lists representing the buckets
	private Node<K, V>[] buckets;

	// Constructor to initialize the bucket array
	public SimpleHashMap() {
		buckets = new Node[CAPACITY];
	}

	// Method to put key-value pair in the map
	public void put(K key, V value) {
		// Generate the hash code and reduce it to a valid bucket index
		int bucketIndex = getBucketIndex(key);
		Node<K, V> newNode = new Node<>(key, value, null);

		// If the bucket is empty, place the new node there
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = newNode;
		} else {
			// Collision handling with chaining
			Node<K, V> current = buckets[bucketIndex];
			while (current.next != null) {
				// If key already exists, replace the value
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			// Add new node at the end of the chain
			current.next = newNode;
		}
	}

	// Method to get a value by key
	public V get(K key) {
		Node<K, V> bucket = buckets[getBucketIndex(key)];
		while (bucket != null) {
			if (bucket.key.equals(key)) {
				return bucket.value;
			}
			bucket = bucket.next;
		}
		return null; // Not found
	}

	// Utility method to get the bucket index
	private int getBucketIndex(K key) {
		return key.hashCode() % CAPACITY;
	}

	// Node class used for chaining in buckets
	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	// Main method to demonstrate map usage
	public static void main(String[] args) {
		SimpleHashMap<String, String> map = new SimpleHashMap<>();
		map.put("name", "John");
		map.put("email", "john@example.com");
		map.put("name", "Mike"); // This will replace "John" with "Mike"

		System.out.println(map.get("name")); // Outputs: Mike
		System.out.println(map.get("email")); // Outputs: john@example.com
	}
}
