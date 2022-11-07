package br.com.api.springsecurity.service.impl;

import br.com.api.springsecurity.entity.ProductModel;
import br.com.api.springsecurity.repository.ProductRepository;
import br.com.api.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductModel create(ProductModel entity) {

        return this.productRepository.save(entity);
    }

    @Transactional
    @Override
    public void delete(ProductModel entity) {
        productRepository.delete(entity);
    }

    @Override
    public Optional<ProductModel> findByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    @Override
    public ProductModel update(ProductModel entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<ProductModel> findById(UUID id) {
        return this.productRepository.findById(id);
    }
}
