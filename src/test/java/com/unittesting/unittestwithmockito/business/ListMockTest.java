package com.unittesting.unittestwithmockito.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ListMockTest {

    List<String> mock = mock(List.class);


    @Test
    public  void  Basic_size(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public  void  ReturnDifferenValues(){
        when(mock.size()).thenReturn(5).thenReturn(10).thenReturn(15);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
        assertEquals(15,mock.size());
    }

    @Test
    public void ReturnWithParameters(){
        when(mock.get(0)).thenReturn("Hello World");
        assertEquals("Hello World",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void genericParameter(){
        when(mock.get(anyInt())).thenReturn("Hello Cyprian");
        assertEquals("Hello Cyprian",mock.get(0));
        assertEquals("Hello Cyprian",mock.get(1));
    }

    @Test
    public  void verification(){
        String value = mock.get(0);
        String value2 = mock.get(1);

        //
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);

    }
    @Test
    public  void  argumentCaptor(){
        //Stud
        mock.add("Hello Bland");
        ArgumentCaptor<String> captor =
                ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("Hello Bland",captor.getValue());
    }

    @Test
    public  void  MultipleargumentCaptor(){
        //Stud
        mock.add("Hello Bland");
        mock.add("Hello Synthia");

        ArgumentCaptor<String> captor =
                ArgumentCaptor.forClass(String.class);

        verify(mock,times(2)).add(captor.capture());

        List<String> allvalues =captor.getAllValues();

        assertEquals("Hello Bland",allvalues.get(0));
        assertEquals("Hello Synthia",allvalues.get(1));
    }

    @Test
    public  void  Spyingto(){
        ArrayList arrayListmock = mock(ArrayList.class);
        System.out.println(arrayListmock.get(0));//null
        System.out.println(arrayListmock.size());//0

        arrayListmock.add("trying");
        arrayListmock.add("trying12");
        System.out.println(arrayListmock.size());//0
        when(arrayListmock.size()).thenReturn(5);
        System.out.println(arrayListmock.size());//5

    }

    @Test
    public  void  Spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("trying1");
        System.out.println(arrayListSpy.get(0));//trying1
        System.out.println(arrayListSpy.size());//1

        arrayListSpy.add("trying");
        arrayListSpy.add("trying12");
        System.out.println(arrayListSpy.size());//3

        when(arrayListSpy.size()).thenReturn(5);

        System.out.println(arrayListSpy.size());//5

        arrayListSpy.add("trying4");
        System.out.println(arrayListSpy.size());//6

    }
}
