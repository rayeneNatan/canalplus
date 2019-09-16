package com.canalplus.blueprint.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.canalplus.blueprint.dto.MovementDTO;
import com.canalplus.blueprint.dto.SubscriberDTO;
import com.canalplus.blueprint.enumeration.MovementEnum;
import com.canalplus.blueprint.event.OnAddressChangeEvent;
import com.canalplus.blueprint.service.SubscriberService;

@Component
public class AddressChangeListener implements ApplicationListener<OnAddressChangeEvent> {
    
    @Autowired
    private SubscriberService service;

    @Override
    public void onApplicationEvent(final OnAddressChangeEvent event) {
        this.changeAddress(event);
    }

    private void changeAddress(final OnAddressChangeEvent event) {
        final SubscriberDTO subscriber = event.getSubscriber();
        MovementDTO movement = createMovement(subscriber);
        subscriber.getMovements().add(movement);
        service.saveOrUpdate(subscriber);
    }

    private final MovementDTO createMovement(final SubscriberDTO subscriber) {
    	MovementDTO mvt = new MovementDTO();
    	mvt.setValue(subscriber.getAddress().toString());
    	mvt.setAdvisor(subscriber.getAdvisor());
    	mvt.setMovementType(MovementEnum.ADRESS_CHANGE);
    	
    	return mvt;	
    }
    
}
