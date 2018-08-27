package com.leetcode.problem;

public class ReverseWords {

	public String reverseWords(String s) {
		int end = -1;
		StringBuilder result = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c != ' ' && end == -1) {
				end = i;
			}
			if (c == ' ' || i == 0) {
				if (end != -1) {
					result.append(s, i == 0 ? 0 : i + 1, end + 1).append(' ');
					end = -1;
				}
			}
		}
		return result.deleteCharAt(result.length() - 1).toString();
	}

}
