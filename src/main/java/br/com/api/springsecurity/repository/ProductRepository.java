package br.com.api.springsecurity.repository;

import br.com.api.springsecurity.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    Optional<ProductModel> findByDescription(String description);
}
