package com.poly.lab5.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.poly.lab5.model.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            item = new Item(id, "Item " + id, id * 10, 1);
            map.put(id, item);
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override public void remove(Integer id) { map.remove(id); }
    @Override public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) item.setQty(qty);
        return item;
    }
    @Override public void clear() { map.clear(); }
    @Override public Collection<Item> getItems() { return map.values(); }
    @Override public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }
    @Override public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
    }
}