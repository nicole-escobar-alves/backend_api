package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.application.dto.product.CreateProductDto;
import br.com.fiap.postech.techchallenge.application.dto.product.ProductDto;
import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-17T10:50:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class IProductMapperImpl implements IProductMapper {

    @Autowired
    private IProductCategoryMapper iProductCategoryMapper;

    @Override
    public Product toDomain(ProductEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( entityBase.getId() );
        product.setCreationTime( entityBase.getCreationTime() );
        product.setIsActive( entityBase.getIsActive() );
        product.setName( entityBase.getName() );
        product.setDescription( entityBase.getDescription() );
        product.setPrice( entityBase.getPrice() );
        product.setDiscountPercent( entityBase.getDiscountPercent() );
        product.setEstimatedTime( entityBase.getEstimatedTime() );
        product.setProductCategory( entityBase.getProductCategory() );

        return product;
    }

    @Override
    public ProductEntity toEntity(Product domain) {
        if ( domain == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( domain.getId() );
        productEntity.setCreationTime( domain.getCreationTime() );
        productEntity.setIsActive( domain.getIsActive() );
        productEntity.setName( domain.getName() );
        productEntity.setDescription( domain.getDescription() );
        productEntity.setPrice( domain.getPrice() );
        productEntity.setEstimatedTime( domain.getEstimatedTime() );
        productEntity.setDiscountPercent( domain.getDiscountPercent() );
        productEntity.setProductCategory( domain.getProductCategory() );

        return productEntity;
    }

    @Override
    public List<Product> toDomains(List<ProductEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( entities.size() );
        for ( ProductEntity productEntity : entities ) {
            list.add( toDomain( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductCategoryName( iProductCategoryMapper.map( product.getProductCategory() ) );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setDiscountPercent( product.getDiscountPercent() );

        return productDto;
    }

    @Override
    public Product toProduct(CreateProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( dto.getName() );
        product.setDescription( dto.getDescription() );
        product.setPrice( dto.getPrice() );
        product.setDiscountPercent( dto.getDiscountPercent() );
        product.setProductCategory( dto.getProductCategory() );

        return product;
    }

    @Override
    public List<ProductDto> toProductsDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDto( product ) );
        }

        return list;
    }
}
