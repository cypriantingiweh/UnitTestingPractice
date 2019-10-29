package com.unittesting.unittestwithmockito.businessimpl;

import com.unittesting.unittestwithmockito.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService somedata;
	
	
  public void setSomedata(SomeDataService somedata) {
		this.somedata = somedata;
	}

public int calculateSum( int [] data) {
	  int sum = 0;
	  for(int value: data) {
		  sum += value;
	  }
	  return sum;
  }
  
  public int calculateSumSomeDataService() {
	  int sum = 0;
	  int [] data = somedata.retrieveAll();
	  for(int value: data) {
		  sum += value;
	  }
	  return sum;
  }
}
