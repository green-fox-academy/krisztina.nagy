package com.greenfoxacademy.webshop.models;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Item> ShopItems;

    public List<Item> getShopItems() {
        return ShopItems;
    }

    public Shop(List<Item> shopItems) {
        ShopItems = shopItems;
    }

    public void Add (Item i){
        ShopItems.add(i);
    }
}
