package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.application.dto.combo.ComboDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import br.com.fiap.postech.techchallenge.application.dto.order.DetailsOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import br.com.fiap.postech.techchallenge.core.domain.Addon;
import br.com.fiap.postech.techchallenge.core.domain.Combo;
import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.Product;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.AddonEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.ComboEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.CustomerEntity;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.OrderEntity;
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
public class IOrderMapperImpl implements IOrderMapper {

    @Autowired
    private IProductMapper iProductMapper;
    @Autowired
    private IAddonMapper iAddonMapper;
    @Autowired
    private IOrderStatusMapper iOrderStatusMapper;

    @Override
    public Order toDomain(OrderEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( entityBase.getId() );
        order.setCreationTime( entityBase.getCreationTime() );
        order.setIsActive( entityBase.getIsActive() );
        order.setCombos( comboEntityListToComboList( entityBase.getCombos() ) );
        order.setTotalPrice( entityBase.getTotalPrice() );
        order.setOrderStatus( entityBase.getOrderStatus() );
        order.setCustomer( customerEntityToCustomer( entityBase.getCustomer() ) );
        order.setFinishedTime( entityBase.getFinishedTime() );

        return order;
    }

    @Override
    public OrderEntity toEntity(Order domain) {
        if ( domain == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( domain.getId() );
        orderEntity.setCreationTime( domain.getCreationTime() );
        orderEntity.setIsActive( domain.getIsActive() );
        orderEntity.setCombos( comboListToComboEntityList( domain.getCombos() ) );
        orderEntity.setTotalPrice( domain.getTotalPrice() );
        orderEntity.setOrderStatus( domain.getOrderStatus() );
        orderEntity.setFinishedTime( domain.getFinishedTime() );
        orderEntity.setCustomer( customerToCustomerEntity( domain.getCustomer() ) );

        return orderEntity;
    }

    @Override
    public List<Order> toDomains(List<OrderEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( entities.size() );
        for ( OrderEntity orderEntity : entities ) {
            list.add( toDomain( orderEntity ) );
        }

        return list;
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setOrderStatus( iOrderStatusMapper.map( order.getOrderStatus() ) );
        orderDto.setTotalPrice( order.getTotalPrice() );

        return orderDto;
    }

    @Override
    public List<OrderDto> toOrdersDto(List<Order> domains) {
        if ( domains == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( domains.size() );
        for ( Order order : domains ) {
            list.add( toOrderDto( order ) );
        }

        return list;
    }

    @Override
    public List<DetailsOrderDto> toDetailsOrdersDto(List<Order> domains) {
        if ( domains == null ) {
            return null;
        }

        List<DetailsOrderDto> list = new ArrayList<DetailsOrderDto>( domains.size() );
        for ( Order order : domains ) {
            list.add( toDetailsOrderDto( order ) );
        }

        return list;
    }

    @Override
    public DetailsOrderDto toDetailsOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        DetailsOrderDto detailsOrderDto = new DetailsOrderDto();

        detailsOrderDto.setId( order.getId() );
        detailsOrderDto.setCombos( comboListToComboDtoList( order.getCombos() ) );
        detailsOrderDto.setTotalPrice( order.getTotalPrice() );
        detailsOrderDto.setOrderStatus( order.getOrderStatus() );
        detailsOrderDto.setCustomer( customerToCustomerDto( order.getCustomer() ) );
        detailsOrderDto.setEstimatedTime( order.getEstimatedTime() );

        return detailsOrderDto;
    }

    protected Combo comboEntityToCombo(ComboEntity comboEntity) {
        if ( comboEntity == null ) {
            return null;
        }

        Product product = null;

        product = iProductMapper.toDomain( comboEntity.getProduct() );

        Combo combo = new Combo( product );

        combo.setId( comboEntity.getId() );
        combo.setCreationTime( comboEntity.getCreationTime() );
        combo.setIsActive( comboEntity.getIsActive() );
        combo.setAddons( iAddonMapper.toDomains( comboEntity.getAddons() ) );
        combo.setTotalPrice( comboEntity.getTotalPrice() );

        return combo;
    }

    protected List<Combo> comboEntityListToComboList(List<ComboEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Combo> list1 = new ArrayList<Combo>( list.size() );
        for ( ComboEntity comboEntity : list ) {
            list1.add( comboEntityToCombo( comboEntity ) );
        }

        return list1;
    }

    protected Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setCreationTime( customerEntity.getCreationTime() );
        customer.setIsActive( customerEntity.getIsActive() );
        customer.setName( customerEntity.getName() );
        customer.setCpf( customerEntity.getCpf() );
        customer.setEmail( customerEntity.getEmail() );

        return customer;
    }

    protected List<AddonEntity> addonListToAddonEntityList(List<Addon> list) {
        if ( list == null ) {
            return null;
        }

        List<AddonEntity> list1 = new ArrayList<AddonEntity>( list.size() );
        for ( Addon addon : list ) {
            list1.add( iAddonMapper.toEntity( addon ) );
        }

        return list1;
    }

    protected ComboEntity comboToComboEntity(Combo combo) {
        if ( combo == null ) {
            return null;
        }

        ComboEntity comboEntity = new ComboEntity();

        comboEntity.setId( combo.getId() );
        comboEntity.setCreationTime( combo.getCreationTime() );
        comboEntity.setIsActive( combo.getIsActive() );
        comboEntity.setProduct( iProductMapper.toEntity( combo.getProduct() ) );
        comboEntity.setAddons( addonListToAddonEntityList( combo.getAddons() ) );
        comboEntity.setTotalPrice( combo.getTotalPrice() );

        return comboEntity;
    }

    protected List<ComboEntity> comboListToComboEntityList(List<Combo> list) {
        if ( list == null ) {
            return null;
        }

        List<ComboEntity> list1 = new ArrayList<ComboEntity>( list.size() );
        for ( Combo combo : list ) {
            list1.add( comboToComboEntity( combo ) );
        }

        return list1;
    }

    protected CustomerEntity customerToCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setCreationTime( customer.getCreationTime() );
        customerEntity.setIsActive( customer.getIsActive() );
        customerEntity.setName( customer.getName() );
        customerEntity.setCpf( customer.getCpf() );
        customerEntity.setEmail( customer.getEmail() );

        return customerEntity;
    }

    protected ComboDto comboToComboDto(Combo combo) {
        if ( combo == null ) {
            return null;
        }

        ComboDto comboDto = new ComboDto();

        comboDto.setProduct( iProductMapper.toProductDto( combo.getProduct() ) );
        comboDto.setAddons( iAddonMapper.toAddonsDto( combo.getAddons() ) );
        comboDto.setTotalPrice( combo.getTotalPrice() );

        return comboDto;
    }

    protected List<ComboDto> comboListToComboDtoList(List<Combo> list) {
        if ( list == null ) {
            return null;
        }

        List<ComboDto> list1 = new ArrayList<ComboDto>( list.size() );
        for ( Combo combo : list ) {
            list1.add( comboToComboDto( combo ) );
        }

        return list1;
    }

    protected CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setCpf( customer.getCpf() );
        customerDto.setEmail( customer.getEmail() );

        return customerDto;
    }
}
