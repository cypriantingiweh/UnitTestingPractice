package com.unittesting.unittestwithmockito.businessimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import com.unittesting.unittestwithmockito.data.SomeDataService;

public class SomeBusinessMockTest {
	
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService somedataservicemock = mock(SomeDataService.class);
	
	@Test
	public void calculateSumSomeData_Basic() {

		when(somedataservicemock.retrieveAll()).thenReturn( new int [] {1,2,3});
		business.setSomedata(somedataservicemock);
		assertEquals(6, business.calculateSumSomeDataService());
		
	}

	@Test
	public void calculateSumSomeData_empty() {
		when(somedataservicemock.retrieveAll()).thenReturn( new int [] {});
		business.setSomedata(somedataservicemock);
		assertEquals(0, business.calculateSumSomeDataService());
		
	}
	
	@Test
	public void calculateSumSomeData_onevalue() {
		when(somedataservicemock.retrieveAll()).thenReturn( new int [] {5});
		business.setSomedata(somedataservicemock);
		assertEquals(5, business.calculateSumSomeDataService());
		
	}
}
