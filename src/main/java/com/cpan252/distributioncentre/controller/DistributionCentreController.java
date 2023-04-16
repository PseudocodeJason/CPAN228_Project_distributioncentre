package com.cpan252.distributioncentre.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.model.dto.CreateCloth;
import com.cpan252.distributioncentre.repository.DistributionCentreRepository;
import com.cpan252.distributioncentre.repository.ItemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/DistributionCentre", produces = "application/json")
public class DistributionCentreController {
    
    private final DistributionCentreRepository distributionCentreRepository;
    private final ItemRepository itemRepository;

    public DistributionCentreController(DistributionCentreRepository distributionCentreRepository, ItemRepository itemRepository){
        this.distributionCentreRepository = distributionCentreRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<DistributionCentre> allCentres(){
        
        return (List<DistributionCentre>) distributionCentreRepository.findAll();
    }

    @GetMapping("/{id}/items")
    public List<Item> getItemsForCentre(@PathVariable int id) {
        var currentDistributionCentre = distributionCentreRepository.findById(id);
        var items = currentDistributionCentre.get().getItem();
        return items;
    }

    @PostMapping("/{id}/items")
    public Item addItemToCentre(@PathVariable int id, @RequestBody Item item) {
        var currentDistributionCentre = distributionCentreRepository.findById(id);
        item.setDistributionCentre(currentDistributionCentre.get());
        var savedItem = itemRepository.save(item);
        return savedItem;
    }

    @DeleteMapping("/items/{id}")
    public void deleteCloth(@PathVariable("id") int id) {
        itemRepository.deleteById(id);
    }
}
