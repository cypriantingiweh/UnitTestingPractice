package com.unittesting.unittestwithmockito.data;

import com.unittesting.unittestwithmockito.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
