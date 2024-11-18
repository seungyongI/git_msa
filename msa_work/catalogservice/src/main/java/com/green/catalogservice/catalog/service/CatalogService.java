package com.green.catalogservice.catalog.service;

import com.green.catalogservice.catalog.vo.CatalogResponse;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.orderservice.order.vo.UserResponse;

public interface CatalogService {
    UserResponse join(CatalogRequest catalogRequest);
    CatalogResponse login(String email, String password);

}
