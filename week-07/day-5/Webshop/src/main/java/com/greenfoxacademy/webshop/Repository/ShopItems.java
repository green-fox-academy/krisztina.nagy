package com.greenfoxacademy.webshop.Repository;

import com.greenfoxacademy.webshop.models.Item;

import java.util.ArrayList;

public class ShopItems {

    ArrayList<Item> shopItems;

    public ArrayList<Item> getShopItems() {
        return shopItems;
    }

    public void AddItem(Item i) {
        this.shopItems.add(i);
    }

    private ShopItems() {
        this.shopItems = new ArrayList();
        this.shopItems.add(new Item(1, "macska", "szőrős", 12.4, 5));
        this.shopItems.add(new Item(2, "róka", "lompos", 230D, 2));
    }

    // singleton pattern:
    private static ShopItems instance;

    public static ShopItems getInstance () {
        if(ShopItems.instance == null) {
            ShopItems.instance = new ShopItems();
        }
        return ShopItems.instance;
    }


}
