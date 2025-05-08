package org.bguerra.javafx.app.javafxappdemo.services;

import org.bguerra.javafx.app.javafxappdemo.models.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class ProductServiceWebClient implements ProductService{

    private final WebClient client;

    private final String baseUrl = "http://localhost:8080";

    public ProductServiceWebClient() {
        client = WebClient.builder().baseUrl(baseUrl).build();
    }

    @Override
    public List<Product> findAll() {
        return client.get()
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList().block();
    }

    @Override
    public Product save(Product product) {
        return client.post()
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public Product update(Product product) {
        return client.put()
                .uri("/{id}", product.getId())
                .bodyValue(product)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public Product delete(Product product) {
        return client.delete()
                .uri("/{id}", product.getId())
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}
