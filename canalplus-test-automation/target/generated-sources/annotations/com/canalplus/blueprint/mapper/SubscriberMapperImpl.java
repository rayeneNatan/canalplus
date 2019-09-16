package com.canalplus.blueprint.mapper;

import com.canalplus.blueprint.domain.Movement;
import com.canalplus.blueprint.domain.Subscriber;
import com.canalplus.blueprint.dto.MovementDTO;
import com.canalplus.blueprint.dto.SubscriberDTO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-16T02:37:48+0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class SubscriberMapperImpl implements SubscriberMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AdvisorMapper advisorMapper;
    @Autowired
    private MovementMapper movementMapper;

    @Override
    public SubscriberDTO toDto(Subscriber subscriber) {
        if ( subscriber == null ) {
            return null;
        }

        SubscriberDTO subscriberDTO = new SubscriberDTO();

        subscriberDTO.setId( subscriber.getId() );
        subscriberDTO.setUsername( subscriber.getUsername() );
        subscriberDTO.setLastName( subscriber.getLastName() );
        subscriberDTO.setEmail( subscriber.getEmail() );
        subscriberDTO.setPassword( subscriber.getPassword() );
        subscriberDTO.setAddress( addressMapper.toDto( subscriber.getAddress() ) );
        subscriberDTO.setAdvisor( advisorMapper.toDto( subscriber.getAdvisor() ) );
        Set<MovementDTO> set = movementSetToMovementDTOSet( subscriber.getMovements() );
        if ( set != null ) {
            subscriberDTO.setMovements( set );
        }
        subscriberDTO.setCreateDate( subscriber.getCreateDate() );

        return subscriberDTO;
    }

    @Override
    public Subscriber toModel(SubscriberDTO subscriberDTO) {
        if ( subscriberDTO == null ) {
            return null;
        }

        Subscriber subscriber = new Subscriber();

        subscriber.setId( subscriberDTO.getId() );
        subscriber.setUsername( subscriberDTO.getUsername() );
        subscriber.setLastName( subscriberDTO.getLastName() );
        subscriber.setEmail( subscriberDTO.getEmail() );
        subscriber.setPassword( subscriberDTO.getPassword() );
        subscriber.setAddress( addressMapper.toModel( subscriberDTO.getAddress() ) );
        subscriber.setAdvisor( advisorMapper.toModel( subscriberDTO.getAdvisor() ) );
        Set<Movement> set = movementDTOSetToMovementSet( subscriberDTO.getMovements() );
        if ( set != null ) {
            subscriber.setMovements( set );
        }
        subscriber.setCreateDate( subscriberDTO.getCreateDate() );

        return subscriber;
    }

    protected Set<MovementDTO> movementSetToMovementDTOSet(Set<Movement> set) {
        if ( set == null ) {
            return null;
        }

        Set<MovementDTO> set_ = new HashSet<MovementDTO>();
        for ( Movement movement : set ) {
            set_.add( movementMapper.toDto( movement ) );
        }

        return set_;
    }

    protected Set<Movement> movementDTOSetToMovementSet(Set<MovementDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Movement> set_ = new HashSet<Movement>();
        for ( MovementDTO movementDTO : set ) {
            set_.add( movementMapper.toModel( movementDTO ) );
        }

        return set_;
    }
}
