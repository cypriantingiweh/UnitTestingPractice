package com.unittesting.unittestwithmockito.businessimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.unittesting.unittestwithmockito.data.SomeDataService;

public class SomeBusinessStudTest {

	SomeBusinessImpl business = new SomeBusinessImpl();

	
	@Test
	public void calculateSumSomeData_Basic() {
		business.setSomedata(new SomeBusinessStud());
		assertEquals(6, business.calculateSumSomeDataService());
		
	}
	
	@Test
	public void calculateSum_empty() {
        business.setSomedata(new SomeBusinessStud());
		assertEquals(0, business.calculateSum(new int [] {}));
		
	}

    @Test
    public void calculateSum_OneValue() {
        business.setSomedata(new SomeBusinessStud());
        assertEquals(5, business.calculateSum(new int [] {5}));

    }

}
