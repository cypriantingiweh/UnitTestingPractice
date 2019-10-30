package com.unittesting.unittestwithmockito.data;

import com.unittesting.unittestwithmockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJdbcTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public  void Findall(){
        List<Item> items = itemRepository.findAll();

        assertEquals(4,items.size());
    }
}
