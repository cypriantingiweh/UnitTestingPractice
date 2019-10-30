package com.unittesting.unittestwithmockito.controller;

import com.unittesting.unittestwithmockito.businessimpl.ItemBusinessService;
import com.unittesting.unittestwithmockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsControllers {

    @Autowired
    private ItemBusinessService businessService;


    @GetMapping("/items")
    public Item DumyItems(){

        return new Item(1,"Blackson",200,30);
    }

    @GetMapping("/items-business")
    public Item DumyItemsFrombusinessService(){
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/retrieve-from-database")
    public List<Item> retrieveAll(){
        return businessService.retrieveAllItems();
    }
}
