package com.unittesting.unittestwithmockito.spike;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String ActualResponse = "{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}";

    @Test
    public  void  JsonAssert_strictTrue_ExactMatchExceeptForSpaces()throws Exception{
        String expectedResponse = "{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30,\"value\":0}";
        JSONAssert.assertEquals(ActualResponse,expectedResponse,true);
    }

    @Test
    public  void  JsonAssert_strictFalse()throws Exception{
        String expectedResponse = "{\"id\":1,\"name\":\"Blackson\",\"price\":200,\"quantity\":30}";
        JSONAssert.assertEquals(ActualResponse,expectedResponse,false);
    }

    @Test
    public  void  JsonAssert_WithoutEscapeChar()throws Exception{
        String expectedResponse = "{id:1,name:Blackson,price:200,quantity:30,value:0}";
        JSONAssert.assertEquals(ActualResponse,expectedResponse,false);
    }
}
