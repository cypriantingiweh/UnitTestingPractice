package com.unittesting.unittestwithmockito.businessimpl;

import com.unittesting.unittestwithmockito.data.ItemRepository;
import com.unittesting.unittestwithmockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	ItemBusinessService itemBusinessService = new ItemBusinessService();


	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void calculateSumSomeData_Basic() {

		when(itemRepository.findAll()).thenReturn(Arrays.asList(
				new Item(1,"balls",10,10)
		));
			List<Item> items = itemBusinessService.retrieveAllItems();
			assertEquals(100,items.get(0).getValue());
	}

}
