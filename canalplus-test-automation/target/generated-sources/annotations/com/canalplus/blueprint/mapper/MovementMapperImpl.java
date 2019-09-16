package com.canalplus.blueprint.mapper;

import com.canalplus.blueprint.domain.Movement;
import com.canalplus.blueprint.dto.MovementDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-16T02:37:48+0200",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class MovementMapperImpl implements MovementMapper {

    @Autowired
    private AdvisorMapper advisorMapper;

    @Override
    public MovementDTO toDto(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        MovementDTO movementDTO = new MovementDTO();

        movementDTO.setMvmtID( movement.getMvmtID() );
        movementDTO.setValue( movement.getValue() );
        movementDTO.setMovementType( movement.getMovementType() );
        movementDTO.setAdvisor( advisorMapper.toDto( movement.getAdvisor() ) );
        movementDTO.setModifDate( movement.getModifDate() );

        return movementDTO;
    }

    @Override
    public Movement toModel(MovementDTO movementsDTO) {
        if ( movementsDTO == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setMvmtID( movementsDTO.getMvmtID() );
        movement.setValue( movementsDTO.getValue() );
        movement.setMovementType( movementsDTO.getMovementType() );
        movement.setAdvisor( advisorMapper.toModel( movementsDTO.getAdvisor() ) );
        movement.setModifDate( movementsDTO.getModifDate() );

        return movement;
    }
}
