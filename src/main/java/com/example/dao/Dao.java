package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Dao<K, T> {

    private Map<K, T> items = new HashMap<>();

    public List<T> findAll() {
        return items.values().stream().collect(Collectors.toList());
    }

    public Optional<T> findById(K id) {
        return Optional.ofNullable(items.get(id));
    }

    public void save(K id, T item) {
        this.items.put(id, item);
    }

    public void delete(K id, T item) {
        this.items.remove(id, item);
    }

}
