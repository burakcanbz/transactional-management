package com.example.inventory.controller;

import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}")
    public String getStockCountByProductId(@PathVariable String id){
        return "Get Stock Count By Product Id" + id;
    }

    @PostMapping("/reserve")
    public String addStockCountByProductId(@RequestBody String body){
        return "Add Stock Count By Product Id";
    }

    @PostMapping("/release")
    public String releaseStockCountByProductId(@RequestBody String body){
        return "release Stock Count By Product Id";
    }

    @PutMapping
    public String updateStockCountByProductId(@RequestBody String body){
        return "Update Stock Count By Product Id";
    }
}
