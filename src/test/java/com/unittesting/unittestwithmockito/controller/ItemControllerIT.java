package com.unittesting.unittestwithmockito.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response =
                this.restTemplate.getForObject("/retrieve-from-database",
                        String.class);
        JSONAssert.assertEquals(
                "[{id:1,name:Black-balls,price:100,quantity:10,value:1000}," +
                "{id:2, name:Blackbery,price:10000,quantity:13,value:130000}," +
                "{id:3,name:hulkebery,price:100000,quantity:20,value:2000000}," +
                        "{id:4,name:Wallet,price:1300,quantity:15,value:19500}," +
                        "{id:5,name:Shoes,price:5000,quantity:12,value:60000}]",
                response,false);
    }

}
