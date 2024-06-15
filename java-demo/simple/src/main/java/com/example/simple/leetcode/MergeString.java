package com.example.simple.leetcode;

public class MergeString {

	public String mergeAlternately(String word1, String word2) {

		int totalLength = word1.length() + word2.length();
		char mergedResult[] = new char[totalLength];
		int indexA = 0;
		int indexB = 0;
		int counter = 0;

		System.out.println("indexA " + " | counter" + " | indexB " + indexB);
		while (counter < totalLength) {
			System.out.println("    " + indexA + " |    " + counter + " |  " + indexB);

			if (counter % 2 == 0 && indexA < word1.length()) {
				mergedResult[counter - indexB] = word1.charAt(indexA++);
				System.out.println("In If block " + word1.charAt(indexA - 1));
			} else if (indexB < word2.length()) {
				System.out.println("In Else block " + word2.charAt(indexA - 1));
				mergedResult[indexA + indexB] = word2.charAt(indexB++);
			}

			System.out.println(new String(mergedResult));
			counter++;
		}

		return new String(mergedResult);
	}

	public static void main(String[] args) {
		System.out.println("Merged String : " + new MergeString().mergeAlternately("abc", "pqr"));
		System.out.println("Merged String : " + new MergeString().mergeAlternatelyOption1("abc", "pqr"));
		System.out.println("Merged String : " + new MergeString().mergeAlternatelyOption2("abc", "pqr"));
	}

	public String mergeAlternatelyOption1(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
		int totalLength = length1 + length2;
		char[] mergedResult = new char[totalLength];

		int index1 = 0, index2 = 0, counter = 0;

		while (counter < totalLength ) {
			if (index1 < length1) {
				mergedResult[counter++] = word1.charAt(index1++);
			}
			if (index2 < length2) {
				mergedResult[counter++] = word2.charAt(index2++);
			}
		}

		return new String(mergedResult);
	}

	public String mergeAlternatelyOption2(String word1, String word2) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < word1.length() || i < word2.length()) {
			if (i < word1.length()) {
				result.append(word1.charAt(i));
			}
			if (i < word2.length()) {
				result.append(word2.charAt(i));
			}
			i++;
		}
		return result.toString();
	}
}