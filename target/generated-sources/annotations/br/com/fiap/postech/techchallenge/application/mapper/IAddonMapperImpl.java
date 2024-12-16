package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.application.dto.addon.AddonDto;
import br.com.fiap.postech.techchallenge.application.dto.addon.CreateAddonDto;
import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T00:08:18-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class IAddonMapperImpl implements IAddonMapper {

    @Autowired
    private IProductCategoryMapper iProductCategoryMapper;

    @Override
    public Addon toDomain(AddonEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Addon addon = new Addon();

        addon.setId( entityBase.getId() );
        addon.setCreationTime( entityBase.getCreationTime() );
        addon.setIsActive( entityBase.getIsActive() );
        addon.setName( entityBase.getName() );
        addon.setPrice( entityBase.getPrice() );
        addon.setProductCategory( entityBase.getProductCategory() );
        if ( entityBase.getDiscountPercent() != null ) {
            addon.setDiscountPercent( entityBase.getDiscountPercent().doubleValue() );
        }

        return addon;
    }

    @Override
    public AddonEntity toEntity(Addon domain) {
        if ( domain == null ) {
            return null;
        }

        AddonEntity addonEntity = new AddonEntity();

        addonEntity.setId( domain.getId() );
        addonEntity.setCreationTime( domain.getCreationTime() );
        addonEntity.setIsActive( domain.getIsActive() );
        addonEntity.setName( domain.getName() );
        addonEntity.setPrice( domain.getPrice() );
        addonEntity.setProductCategory( domain.getProductCategory() );
        if ( domain.getDiscountPercent() != null ) {
            addonEntity.setDiscountPercent( BigDecimal.valueOf( domain.getDiscountPercent() ) );
        }

        return addonEntity;
    }

    @Override
    public List<Addon> toDomains(List<AddonEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Addon> list = new ArrayList<Addon>( entities.size() );
        for ( AddonEntity addonEntity : entities ) {
            list.add( toDomain( addonEntity ) );
        }

        return list;
    }

    @Override
    public AddonDto toAddonDto(Addon addon) {
        if ( addon == null ) {
            return null;
        }

        AddonDto.AddonDtoBuilder addonDto = AddonDto.builder();

        addonDto.productCategoryName( iProductCategoryMapper.map( addon.getProductCategory() ) );
        addonDto.id( addon.getId() );
        addonDto.name( addon.getName() );
        addonDto.price( addon.getPrice() );
        addonDto.discountPercent( addon.getDiscountPercent() );

        return addonDto.build();
    }

    @Override
    public Addon toDomain(CreateAddonDto dto) {
        if ( dto == null ) {
            return null;
        }

        Addon addon = new Addon();

        addon.setName( dto.getName() );
        addon.setPrice( dto.getPrice() );
        addon.setProductCategory( dto.getProductCategory() );
        addon.setDiscountPercent( dto.getDiscountPercent() );

        return addon;
    }

    @Override
    public List<AddonDto> toAddonsDto(List<Addon> domains) {
        if ( domains == null ) {
            return null;
        }

        List<AddonDto> list = new ArrayList<AddonDto>( domains.size() );
        for ( Addon addon : domains ) {
            list.add( toAddonDto( addon ) );
        }

        return list;
    }
}
