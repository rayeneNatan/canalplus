package com.canalplus.blueprint.event;

import org.springframework.context.ApplicationEvent;

import com.canalplus.blueprint.dto.SubscriberDTO;

@SuppressWarnings("serial")
public class OnAddressChangeEvent extends ApplicationEvent {

    private final SubscriberDTO subscriber;

    public OnAddressChangeEvent(SubscriberDTO subscriberDTO) {
	super(subscriberDTO);
	this.subscriber = subscriberDTO;
    }

    public SubscriberDTO getSubscriber() {
	return subscriber;
    }
}
