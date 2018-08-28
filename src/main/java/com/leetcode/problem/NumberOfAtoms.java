package com.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms {

	public String countOfAtoms(String formula) {
		List<Element> elements = new ArrayList<>();
		LinkedList<Integer> stack = new LinkedList<>();
		int i = 0;
		StringBuilder currentElement = new StringBuilder();
		StringBuilder currentCount = new StringBuilder();
		while (i < formula.length()) {
			char c = formula.charAt(i);
			if (Character.isUpperCase(c)) {
				addElement(elements, currentElement, currentCount);
				currentElement.append(c);
			}
			if (Character.isLowerCase(c)) {
				currentElement.append(c);
			}
			if (Character.isDigit(c)) {
				currentCount.append(c);
			}
			if (c == '(') {
				addElement(elements, currentElement, currentCount);
				stack.push(elements.size() - 1);
			}
			if (c == ')') {
				addElement(elements, currentElement, currentCount);
				i++;
				while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
					currentCount.append(formula.charAt(i));
					i++;
				}
				i--;
				if (currentCount.length() == 0) {
					stack.pop();
				} else {
					Integer count = Integer.valueOf(currentCount.toString());
					for (int j = stack.pop()+1; j < elements.size(); j++) {
						Element e = elements.get(j);
						e.count *= count;
					}
					currentCount.setLength(0);
				}
			}
			i++;
		}
		addElement(elements, currentElement, currentCount);
		Map<String, Integer> result = new TreeMap<>();
		for (Element element : elements) {
			if (result.containsKey(element.name)) {
				result.replace(element.name, result.get(element.name) + element.count);
			} else {
				result.put(element.name, element.count);
			}
		}

		StringBuilder toString = new StringBuilder();
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			toString.append(entry.getKey()).append(entry.getValue() == 1 ? "" : entry.getValue());
		}
		return toString.toString();
	}

	private static void addElement(List<Element> elements, StringBuilder elementName, StringBuilder elementCount) {
		if (elementName.length() > 0) {
			elements.add(Element.of(elementName, elementCount));
			elementName.setLength(0);
			elementCount.setLength(0);
		}
	}

	private static class Element {
		String name;
		Integer count;

		static Element of(StringBuilder name, StringBuilder count) {
			return new Element(name.toString(), count.length() != 0 ? Integer.valueOf(count.toString()) : 1);
		}

		Element(String name, Integer count) {
			this.name = name;
			this.count = count;
		}

		@Override
		public String toString() {
			return name + (count == 1 ? "" : count);
		}
	}


}
