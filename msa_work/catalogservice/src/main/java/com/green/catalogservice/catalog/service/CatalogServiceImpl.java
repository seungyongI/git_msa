package com.green.catalogservice.catalog.service;

import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    // controller
    @Override
    public List<CatalogResponse> getCatalogs() {
        List<CatalogEntity> list = catalogRepository.findAll();
        List<CatalogResponse> catalogResponses = new ArrayList<>();
        list.forEach(
                catalogEntity -> catalogResponses.add(new ModelMapper().map(catalogEntity, CatalogResponse.class))
        );
        return catalogResponses;
    }

    //kafka consumer
    @Override
    public CatalogResponse modifyCatalog(CatalogRequest catalogRequest) {
        CatalogEntity catalogEntity = catalogRepository.findByProductId(catalogRequest.getProductId())
                .orElseThrow(() -> new CatalogException("해당 제품이 없습니다."));

        catalogEntity.setStock(catalogRequest.getStock());
        CatalogEntity dbCatalogEntity = catalogRepository.save(catalogEntity);

        return new ModelMapper().map(dbCatalogEntity, CatalogResponse.class);
    }

}
