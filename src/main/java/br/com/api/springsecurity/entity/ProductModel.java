package br.com.api.springsecurity.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "PRO_ID")
    private UUID id;

    @Column(name = "PRO_DESCRIPTION")
    @NotNull
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
