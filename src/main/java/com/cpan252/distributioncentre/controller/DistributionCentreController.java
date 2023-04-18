package com.cpan252.distributioncentre.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

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
    
    @DeleteMapping("/{centreId}/items/{itemId}")
    public ResponseEntity<Void> deleteItemFromCentre(@PathVariable int centreId, @PathVariable int itemId) {
        Optional<DistributionCentre> optionalDistributionCentre = distributionCentreRepository.findById(centreId);
        if (optionalDistributionCentre.isPresent()) {
            DistributionCentre distributionCentre = optionalDistributionCentre.get();
            Optional<Item> optionalItem = itemRepository.findById(itemId);
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                if (item.getDistributionCentre().equals(distributionCentre)) {
                    itemRepository.delete(item);
                    return ResponseEntity.noContent().build();
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @GetMapping("/{id}/items/by-brand/{brand}")
    public ResponseEntity<List<Item>> getItemsByBrandForCentre(@PathVariable int id, @PathVariable String brand) {
        Optional<DistributionCentre> optionalDistributionCentre = distributionCentreRepository.findById(id);
        if (optionalDistributionCentre.isPresent()) {
            DistributionCentre distributionCentre = optionalDistributionCentre.get();
            List<Item> items = distributionCentre.getItem();
            List<Item> itemsByBrand = new ArrayList<>();
            for (Item item : items) {
                if (item.getBrand().toString().equalsIgnoreCase(brand)) {
                    itemsByBrand.add(item);
                }
            }
            if (itemsByBrand.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(itemsByBrand);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/{id}/items/by-name/{name}")
    public ResponseEntity<List<Item>> getItemsByNameForCentre(@PathVariable int id, @PathVariable String name) {
        Optional<DistributionCentre> optionalDistributionCentre = distributionCentreRepository.findById(id);
        if (optionalDistributionCentre.isPresent()) {
            DistributionCentre distributionCentre = optionalDistributionCentre.get();
            List<Item> items = distributionCentre.getItem();
            List<Item> itemsByName = new ArrayList<>();
            for (Item item : items) {
                if (item.getName().toString().equalsIgnoreCase(name)) {
                    itemsByName.add(item);
                }
            }
            if (itemsByName.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(itemsByName);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
