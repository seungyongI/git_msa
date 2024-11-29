package com.green.catalogservice.catalog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CatalogResponse {

    private Long id;
    private String productId; // p-001
    private String productName;
    private int stock; // -100
    private Date createdAt;
}
