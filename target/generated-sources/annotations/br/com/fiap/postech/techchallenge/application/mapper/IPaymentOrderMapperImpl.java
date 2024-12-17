package br.com.fiap.postech.techchallenge.application.mapper;

import br.com.fiap.postech.techchallenge.application.dto.payment.PaymentOrderDTO;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.domain.PaymentOrder;
import br.com.fiap.postech.techchallenge.infrastructure.jpa.entities.PaymentOrderEntity;
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
public class IPaymentOrderMapperImpl implements IPaymentOrderMapper {

    @Autowired
    private IOrderMapper iOrderMapper;

    @Override
    public PaymentOrder toDomain(PaymentOrderEntity entityBase) {
        if ( entityBase == null ) {
            return null;
        }

        Order order = null;

        order = iOrderMapper.toDomain( entityBase.getOrder() );

        PaymentOrder paymentOrder = new PaymentOrder( order );

        paymentOrder.setId( entityBase.getId() );
        paymentOrder.setCreationTime( entityBase.getCreationTime() );
        paymentOrder.setIsActive( entityBase.getIsActive() );
        paymentOrder.setPaymentStatus( entityBase.getPaymentStatus() );
        paymentOrder.setTotalPrice( entityBase.getTotalPrice() );
        paymentOrder.setPaymentType( entityBase.getPaymentType() );
        paymentOrder.setQrCode( entityBase.getQrCode() );

        return paymentOrder;
    }

    @Override
    public PaymentOrderEntity toEntity(PaymentOrder domain) {
        if ( domain == null ) {
            return null;
        }

        PaymentOrderEntity paymentOrderEntity = new PaymentOrderEntity();

        paymentOrderEntity.setId( domain.getId() );
        paymentOrderEntity.setCreationTime( domain.getCreationTime() );
        paymentOrderEntity.setIsActive( domain.getIsActive() );
        paymentOrderEntity.setPaymentType( domain.getPaymentType() );
        paymentOrderEntity.setPaymentStatus( domain.getPaymentStatus() );
        paymentOrderEntity.setTotalPrice( domain.getTotalPrice() );
        paymentOrderEntity.setOrder( iOrderMapper.toEntity( domain.getOrder() ) );
        paymentOrderEntity.setQrCode( domain.getQrCode() );

        return paymentOrderEntity;
    }

    @Override
    public List<PaymentOrder> toDomains(List<PaymentOrderEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentOrder> list = new ArrayList<PaymentOrder>( entities.size() );
        for ( PaymentOrderEntity paymentOrderEntity : entities ) {
            list.add( toDomain( paymentOrderEntity ) );
        }

        return list;
    }

    @Override
    public PaymentOrderDTO toPaymentOrderDTO(PaymentOrder paymentOrder) {
        if ( paymentOrder == null ) {
            return null;
        }

        PaymentOrderDTO paymentOrderDTO = new PaymentOrderDTO();

        paymentOrderDTO.setPaymentStatusName( paymentOrder.getPaymentStatus() );
        paymentOrderDTO.setPaymentTypeName( paymentOrder.getPaymentType() );
        paymentOrderDTO.setId( paymentOrder.getId() );
        paymentOrderDTO.setTotalPrice( paymentOrder.getTotalPrice() );
        paymentOrderDTO.setQrCode( paymentOrder.getQrCode() );

        return paymentOrderDTO;
    }

    @Override
    public List<PaymentOrderDTO> toPaymentOrderDTO(List<PaymentOrder> paymentOrder) {
        if ( paymentOrder == null ) {
            return null;
        }

        List<PaymentOrderDTO> list = new ArrayList<PaymentOrderDTO>( paymentOrder.size() );
        for ( PaymentOrder paymentOrder1 : paymentOrder ) {
            list.add( toPaymentOrderDTO( paymentOrder1 ) );
        }

        return list;
    }
}
