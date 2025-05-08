package org.bguerra.javafx.app.javafxappdemo.services;

import org.bguerra.javafx.app.javafxappdemo.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

    Product update(Product product);

    Product delete(Product product);
}
