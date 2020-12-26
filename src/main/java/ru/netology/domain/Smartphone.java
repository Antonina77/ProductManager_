package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String producer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, double cost, String producer) {
        super(id, name, cost);
        this.producer = producer;
    }
}
