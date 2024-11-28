package com.green.catalogservice.catalog.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "catalogs")
public class CatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
