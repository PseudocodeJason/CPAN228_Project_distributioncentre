package com.cpan252.distributioncentre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpan252.distributioncentre.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

  // Find all items by brand and name
  @Query("SELECT i FROM Item i WHERE i.brand = ?1 AND i.name = ?2")
  List<Item> findAllByBrandAndName(String brand, String name);

}
