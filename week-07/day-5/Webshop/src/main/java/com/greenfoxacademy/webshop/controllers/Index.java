package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.Item;
import com.greenfoxacademy.webshop.models.Shop;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Index {

    private Shop shop;

    public Index () {
        this.shop = new Shop(); //ezt miert igy kell?
    }

    @RequestMapping("/")
    public String Index(Model model) {
        List<Item> items = this.shop.getItems();
        model.addAttribute("items", items);
        return "Index";
    }

        @RequestMapping("/add-items")
    public String addItems() {
        return "add-items";
    }

    @RequestMapping("/items")
    public String filterItems(Model model, @RequestParam int quantity) {

        List<Integer> myList = new ArrayList();
        List<Item> items = this.shop.getItems();

        model.addAttribute("items", items
                .stream()
                .filter(item -> item.quantity > quantity) // ezt az itemet honnan szedi??
                .collect(Collectors.toList()));
        return "index";
    }

    @PostMapping(
            value="/items",
            consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addItem(@RequestBody MultiValueMap<String, String> formData) {
        Item newItem = new Item(
                Integer.parseInt(formData.toSingleValueMap().get("id")),
                formData.toSingleValueMap().get("name"),
                formData.toSingleValueMap().get("description"),
                Double.parseDouble(formData.toSingleValueMap().get("price")),
                Integer.parseInt(formData.toSingleValueMap().get("quantity"))
        );
        this.shop.addItem(newItem);
        return "redirect:/";
    }

}
