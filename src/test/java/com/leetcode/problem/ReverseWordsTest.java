package com.leetcode.problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

	@Test
	public void reverseWords() {
		ReverseWords reverseWords = new ReverseWords();
		assertEquals("blue is sky the", reverseWords.reverseWords("the sky is blue"));
		assertEquals("b a", reverseWords.reverseWords("   a     b    "));
	}
}