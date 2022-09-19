package br.com.api.springsecurity.controller;

import br.com.api.springsecurity.entity.ProductModel;
import br.com.api.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductModel entity) {
        Optional<ProductModel> product = this.productService.findByDescription(entity.getDescription());

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.create(entity));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<?> delete(@PathVariable("idProduct") UUID id) {
        Optional<ProductModel> product = this.productService.findById(id);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        this.productService.delete(product.get());

        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/findByDescription/{description}")
    public ResponseEntity<?> findByDescription(@PathVariable("description") String description) {
        Optional<ProductModel> product = this.productService.findByDescription(description);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        return ResponseEntity.ok().body(product.get());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<ProductModel> update(@RequestBody ProductModel entity) {
        return ResponseEntity.ok().body(this.productService.update(entity));
    }
}
