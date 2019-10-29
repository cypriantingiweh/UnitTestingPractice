package com.unittesting.unittestwithmockito.businessimpl;

import com.unittesting.unittestwithmockito.data.SomeDataService;

public class SomeBusinessStud implements SomeDataService{

	@Override
	public int[] retrieveAll() {
		
		return new int [] {1,2,3};
	}
	
}
