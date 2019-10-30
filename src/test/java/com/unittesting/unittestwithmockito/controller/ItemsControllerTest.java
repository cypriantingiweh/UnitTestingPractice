package com.unittesting.unittestwithmockito.controller;


import com.unittesting.unittestwithmockito.businessimpl.ItemBusinessService;
import com.unittesting.unittestwithmockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemsControllers.class)
public class ItemsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

   @Test
    public  void  DummyItems_basic() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}"))
                .andReturn();

        /*assertEquals("{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}",
                mvcResult.getResponse().getContentAsString());*/

    }

    @Test
    public  void  ItemBusinessService_basic() throws Exception{

       when(itemBusinessService.retrieveHardCodedItem())
               .thenReturn(new Item(1,"balls",1500,10));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/items-business")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:balls,price:1500,quantity:10,value:0}"))
                .andReturn();

        /*assertEquals("{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}",
                mvcResult.getResponse().getContentAsString());*/

    }

    @Test
    public  void  ItemBusinessServiceAll_basic() throws Exception{

        when(itemBusinessService.retrieveAllItems())
                .thenReturn(Arrays.asList(new Item(1,"balls",1500,10),
                        new Item(2,"Blackbery",10000,20)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/retrieve-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:balls,price:1500,quantity:10,value:0}," +
                        "{id:2,name:Blackbery,price:10000,quantity:20,value:0}]"))
                .andReturn();

        /*assertEquals("{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}",
                mvcResult.getResponse().getContentAsString());*/

    }
}
