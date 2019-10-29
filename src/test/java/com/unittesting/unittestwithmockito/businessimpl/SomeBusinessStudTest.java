package com.unittesting.unittestwithmockito.businessimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.unittesting.unittestwithmockito.data.SomeDataService;

public class SomeBusinessStudTest {
	
	@Test
	public void calculateSumSomeData_Basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomedata(new SomeBusinessStud());
		int ActualResult = business.calculateSumSomeDataService();
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
