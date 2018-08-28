package com.leetcode.problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfAtomsTest {

	@Test
	public void countOfAtoms() {
		NumberOfAtoms sut = new NumberOfAtoms();
		assertEquals("H2O", sut.countOfAtoms("H2O"));
		assertEquals("H2MgO2", sut.countOfAtoms("Mg(OH)2"));
		assertEquals("K4N2O14S4", sut.countOfAtoms("K4(ON(SO3)2)2"));
		assertEquals("Be7956H306He8874", sut.countOfAtoms("((HHe28Be26He)9)34"));
	}
}