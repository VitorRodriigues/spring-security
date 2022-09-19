package br.com.api.springsecurity.service;

import br.com.api.springsecurity.entity.ProductModel;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    ProductModel create(ProductModel entity);

    void delete(ProductModel entity);


    Optional<ProductModel> findByDescription(String description);

    ProductModel update(ProductModel entity);

    Optional<ProductModel> findById(UUID id);

    
}
