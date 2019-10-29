package com.unittesting.unittestwithmockito.business;

import com.unittesting.unittestwithmockito.model.Item;
import com.unittesting.unittestwithmockito.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    private ItemRepository repository;


}
