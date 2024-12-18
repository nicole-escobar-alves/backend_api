package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.application.dto.customer.CreateCustomerDto;
import br.com.fiap.postech.techchallenge.application.dto.customer.CustomerDto;
import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.CustomerEntity;
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
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer toDomain(CustomerEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( entityBase.getId() );
        customer.setCreationTime( entityBase.getCreationTime() );
        customer.setIsActive( entityBase.getIsActive() );
        customer.setName( entityBase.getName() );
        customer.setCpf( entityBase.getCpf() );
        customer.setEmail( entityBase.getEmail() );

        return customer;
    }

    @Override
    public CustomerEntity toEntity(Customer domain) {
        if ( domain == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( domain.getId() );
        customerEntity.setCreationTime( domain.getCreationTime() );
        customerEntity.setIsActive( domain.getIsActive() );
        customerEntity.setName( domain.getName() );
        customerEntity.setCpf( domain.getCpf() );
        customerEntity.setEmail( domain.getEmail() );

        return customerEntity;
    }

    @Override
    public List<Customer> toDomains(List<CustomerEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( entities.size() );
        for ( CustomerEntity customerEntity : entities ) {
            list.add( toDomain( customerEntity ) );
        }

        return list;
    }

    @Override
    public Customer toCustomer(CreateCustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( dto.getName() );
        customer.setCpf( dto.getCpf() );
        customer.setEmail( dto.getEmail() );

        return customer;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customerSaved) {
        if ( customerSaved == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customerSaved.getId() );
        customerDto.setName( customerSaved.getName() );
        customerDto.setCpf( customerSaved.getCpf() );
        customerDto.setEmail( customerSaved.getEmail() );

        return customerDto;
    }
}
