package com.cpan252.distributioncentre.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.repository.DistributionCentreRepository;
import com.cpan252.distributioncentre.repository.ItemRepository;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final DistributionCentreRepository distributionCentreRepository;
    private final ItemRepository itemRepository;

    public InventoryController(DistributionCentreRepository distributionCentreRepository, ItemRepository itemRepository) {
        this.distributionCentreRepository = distributionCentreRepository;
        this.itemRepository = itemRepository;
    }

    // Add an item to a specific distribution centre
    @PostMapping("/distribution-centre/{centreId}/item")
    public Item addItemToCentre(@PathVariable Integer centreId, @RequestBody Item item) {
        // Find the distribution centre by ID
        DistributionCentre centre = distributionCentreRepository.findById(centreId).orElseThrow(() -> new RuntimeException("Distribution Centre not found"));
        // Set the distribution centre for the item
        item.setDistributionCentre(centre);
        // Save the item and return it
        return itemRepository.save(item);
    }

    // Delete an item by its ID
    @DeleteMapping("/item/{itemId}")
    public void deleteItem(@PathVariable Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    // List all distribution centres
    @GetMapping("/distribution-centres")
    public List<DistributionCentre> listAllDistributionCentres() {
        return (List<DistributionCentre>) distributionCentreRepository.findAll();
    }

    // Request an item by brand and name
    @GetMapping("/items/search")
    public List<Item> requestItemByBrandAndName(String brand, String name) {
        return itemRepository.findAllByBrandAndName(brand, name);
    }
}
