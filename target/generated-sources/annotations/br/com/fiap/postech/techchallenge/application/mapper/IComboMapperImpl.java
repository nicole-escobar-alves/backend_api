package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.core.domain.Combo;
import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ComboEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ProductEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-17T10:50:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class IComboMapperImpl implements IComboMapper {

    @Override
    public Combo toDomain(ComboEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Product product = null;

        product = productEntityToProduct( entityBase.getProduct() );

        Combo combo = new Combo( product );

        combo.setId( entityBase.getId() );
        combo.setCreationTime( entityBase.getCreationTime() );
        combo.setIsActive( entityBase.getIsActive() );
        combo.setAddons( addonEntityListToAddonList( entityBase.getAddons() ) );
        combo.setTotalPrice( entityBase.getTotalPrice() );

        return combo;
    }

    @Override
    public ComboEntity toEntity(Combo domain) {
        if ( domain == null ) {
            return null;
        }

        ComboEntity comboEntity = new ComboEntity();

        comboEntity.setId( domain.getId() );
        comboEntity.setCreationTime( domain.getCreationTime() );
        comboEntity.setIsActive( domain.getIsActive() );
        comboEntity.setProduct( productToProductEntity( domain.getProduct() ) );
        comboEntity.setAddons( addonListToAddonEntityList( domain.getAddons() ) );
        comboEntity.setTotalPrice( domain.getTotalPrice() );

        return comboEntity;
    }

    @Override
    public List<Combo> toDomains(List<ComboEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Combo> list = new ArrayList<Combo>( entities.size() );
        for ( ComboEntity comboEntity : entities ) {
            list.add( toDomain( comboEntity ) );
        }

        return list;
    }

    protected Product productEntityToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setCreationTime( productEntity.getCreationTime() );
        product.setIsActive( productEntity.getIsActive() );
        product.setName( productEntity.getName() );
        product.setDescription( productEntity.getDescription() );
        product.setPrice( productEntity.getPrice() );
        product.setDiscountPercent( productEntity.getDiscountPercent() );
        product.setEstimatedTime( productEntity.getEstimatedTime() );
        product.setProductCategory( productEntity.getProductCategory() );

        return product;
    }

    protected Addon addonEntityToAddon(AddonEntity addonEntity) {
        if ( addonEntity == null ) {
            return null;
        }

        Addon addon = new Addon();

        addon.setId( addonEntity.getId() );
        addon.setCreationTime( addonEntity.getCreationTime() );
        addon.setIsActive( addonEntity.getIsActive() );
        addon.setName( addonEntity.getName() );
        addon.setPrice( addonEntity.getPrice() );
        addon.setProductCategory( addonEntity.getProductCategory() );
        if ( addonEntity.getDiscountPercent() != null ) {
            addon.setDiscountPercent( addonEntity.getDiscountPercent().doubleValue() );
        }

        return addon;
    }

    protected List<Addon> addonEntityListToAddonList(List<AddonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Addon> list1 = new ArrayList<Addon>( list.size() );
        for ( AddonEntity addonEntity : list ) {
            list1.add( addonEntityToAddon( addonEntity ) );
        }

        return list1;
    }

    protected ProductEntity productToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setCreationTime( product.getCreationTime() );
        productEntity.setIsActive( product.getIsActive() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setEstimatedTime( product.getEstimatedTime() );
        productEntity.setDiscountPercent( product.getDiscountPercent() );
        productEntity.setProductCategory( product.getProductCategory() );

        return productEntity;
    }

    protected AddonEntity addonToAddonEntity(Addon addon) {
        if ( addon == null ) {
            return null;
        }

        AddonEntity addonEntity = new AddonEntity();

        addonEntity.setId( addon.getId() );
        addonEntity.setCreationTime( addon.getCreationTime() );
        addonEntity.setIsActive( addon.getIsActive() );
        addonEntity.setName( addon.getName() );
        addonEntity.setPrice( addon.getPrice() );
        addonEntity.setProductCategory( addon.getProductCategory() );
        if ( addon.getDiscountPercent() != null ) {
            addonEntity.setDiscountPercent( BigDecimal.valueOf( addon.getDiscountPercent() ) );
        }

        return addonEntity;
    }

    protected List<AddonEntity> addonListToAddonEntityList(List<Addon> list) {
        if ( list == null ) {
            return null;
        }

        List<AddonEntity> list1 = new ArrayList<AddonEntity>( list.size() );
        for ( Addon addon : list ) {
            list1.add( addonToAddonEntity( addon ) );
        }

        return list1;
    }
}
