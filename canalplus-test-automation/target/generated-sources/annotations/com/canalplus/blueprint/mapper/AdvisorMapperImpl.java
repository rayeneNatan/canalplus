package com.canalplus.blueprint.mapper;

import com.canalplus.blueprint.domain.Advisor;
import com.canalplus.blueprint.dto.AdvisorDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-16T02:37:48+0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class AdvisorMapperImpl implements AdvisorMapper {

    @Override
    public AdvisorDTO toDto(Advisor advisor) {
        if ( advisor == null ) {
            return null;
        }

        AdvisorDTO advisorDTO = new AdvisorDTO();

        advisorDTO.setAdvisorID( advisor.getAdvisorID() );
        advisorDTO.setUsername( advisor.getUsername() );
        advisorDTO.setLastName( advisor.getLastName() );
        advisorDTO.setEmail( advisor.getEmail() );
        advisorDTO.setPassword( advisor.getPassword() );
        advisorDTO.setCanal( advisor.getCanal() );
        advisorDTO.setCreateDate( advisor.getCreateDate() );

        return advisorDTO;
    }

    @Override
    public Advisor toModel(AdvisorDTO advisorDTO) {
        if ( advisorDTO == null ) {
            return null;
        }

        Advisor advisor = new Advisor();

        advisor.setAdvisorID( advisorDTO.getAdvisorID() );
        advisor.setUsername( advisorDTO.getUsername() );
        advisor.setLastName( advisorDTO.getLastName() );
        advisor.setEmail( advisorDTO.getEmail() );
        advisor.setPassword( advisorDTO.getPassword() );
        advisor.setCanal( advisorDTO.getCanal() );
        advisor.setCreateDate( advisorDTO.getCreateDate() );

        return advisor;
    }
}
