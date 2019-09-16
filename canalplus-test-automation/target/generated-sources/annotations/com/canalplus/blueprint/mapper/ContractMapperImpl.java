package com.canalplus.blueprint.mapper;

import com.canalplus.blueprint.domain.Contract;
import com.canalplus.blueprint.dto.ContractDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-16T02:37:48+0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ContractMapperImpl implements ContractMapper {

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Override
    public ContractDTO toDto(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractDTO contractDTO = new ContractDTO();

        contractDTO.setIdContract( contract.getIdContract() );
        contractDTO.setName( contract.getName() );
        contractDTO.setSubscriber( subscriberMapper.toDto( contract.getSubscriber() ) );
        contractDTO.setCreateDate( contract.getCreateDate() );

        return contractDTO;
    }

    @Override
    public Contract toModel(ContractDTO contractDTO) {
        if ( contractDTO == null ) {
            return null;
        }

        Contract contract = new Contract();

        contract.setIdContract( contractDTO.getIdContract() );
        contract.setName( contractDTO.getName() );
        contract.setSubscriber( subscriberMapper.toModel( contractDTO.getSubscriber() ) );
        contract.setCreateDate( contractDTO.getCreateDate() );

        return contract;
    }

    @Override
    public List<ContractDTO> toDto(List<Contract> contracts) {
        if ( contracts == null ) {
            return null;
        }

        List<ContractDTO> list = new ArrayList<ContractDTO>();
        for ( Contract contract : contracts ) {
            list.add( toDto( contract ) );
        }

        return list;
    }
}
