package com.green.catalogservice.catalog.service;

import com.green.catalogservice.error.OrderException;
import com.green.orderservice.jwt.JwtUtils;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.orderservice.order.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(CatalogRequest catalogRequest) {
        String reqEmail = catalogRequest.getEmail();

        catalogRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new OrderException(String.format("'%s'는 이미 존재하는 이메일입니다.", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        CatalogEntity catalogEntity = mapper.map(catalogRequest, CatalogEntity.class);
        catalogEntity.setUserId(UUID.randomUUID().toString());
        catalogEntity = catalogRepository.save(catalogEntity);

        UserResponse userResponse = mapper.map(catalogEntity, UserResponse.class);

        return userResponse;
    }

    @Override
    public CatalogResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        CatalogEntity catalogEntity = catalogRepository.findByEmailAndPassword(email, password)
                .orElseThrow(
                        () -> new OrderException("Invaild email or password")
                );

        CatalogResponse catalogResponse = new CatalogResponse();
        catalogResponse.setUserId(catalogEntity.getUserId());
        catalogResponse.setAccessToken(jwtUtils.createAccessToken(catalogEntity.getEmail(), catalogEntity.getUserId()));
        catalogResponse.setRefreshToken(jwtUtils.createRefreshToken(catalogEntity.getEmail()));

        return catalogResponse;
    }

}
