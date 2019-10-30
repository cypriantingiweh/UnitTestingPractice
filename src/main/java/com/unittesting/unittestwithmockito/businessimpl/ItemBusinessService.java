package com.unittesting.unittestwithmockito.businessimpl;

import com.unittesting.unittestwithmockito.data.ItemRepository;
import com.unittesting.unittestwithmockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService  {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {

        return  new Item(2,"Blackbery",300,10);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();

        for(Item item:items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
