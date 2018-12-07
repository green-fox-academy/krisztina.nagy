package com.greenfoxacademy.webshop.models;

import com.greenfoxacademy.webshop.Repository.ShopItems;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public ArrayList<Item> getItems() {
        return ShopItems.getInstance().getShopItems();
    }

    public Item getItem( int id ) {
        for (Item item: ShopItems.getInstance().getShopItems()){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void addItem(Item i) {
        boolean isInStock = false;
        for (Item item : ShopItems.getInstance().getShopItems()) {
            if (item.getId()== i.getId()){
                isInStock=true;
                item.quantity+=i.quantity;
            }
        }
        if(!isInStock) {
            ShopItems.getInstance().AddItem(i);
        }
    }




}
