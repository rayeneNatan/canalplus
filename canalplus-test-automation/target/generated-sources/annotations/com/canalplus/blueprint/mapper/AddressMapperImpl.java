package com.canalplus.blueprint.mapper;

import com.canalplus.blueprint.domain.Address;
import com.canalplus.blueprint.dto.AddressDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-16T02:37:48+0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setAddressID( address.getAddressID() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setState( address.getState() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setNumber( address.getNumber() );
        addressDTO.setZip( address.getZip() );
        addressDTO.setActive( address.getActive() );
        addressDTO.setType( address.getType() );

        return addressDTO;
    }

    @Override
    public Address toModel(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressID( addressDTO.getAddressID() );
        address.setCountry( addressDTO.getCountry() );
        address.setState( addressDTO.getState() );
        address.setStreet( addressDTO.getStreet() );
        address.setNumber( addressDTO.getNumber() );
        address.setCity( addressDTO.getCity() );
        address.setZip( addressDTO.getZip() );
        address.setActive( addressDTO.getActive() );
        address.setType( addressDTO.getType() );

        return address;
    }
}
