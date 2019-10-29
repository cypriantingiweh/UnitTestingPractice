package com.unittesting.unittestwithmockito.businessimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_Basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int ActualResult = business.calculateSum(new int [] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, ActualResult);
		
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int ActualResult = business.calculateSum(new int [] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, ActualResult);
		
	}

}
