package com.canalplus.blueprint.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.blueprint.dto.AddressDTO;
import com.canalplus.blueprint.dto.ContractDTO;
import com.canalplus.blueprint.dto.SubscriberDTO;
import com.canalplus.blueprint.event.OnAddressChangeEvent;
import com.canalplus.blueprint.service.ContractService;
import com.canalplus.blueprint.service.SubscriberService;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private ContractService contractService;

    @PostMapping("/save")
    public ResponseEntity<SubscriberDTO> saveSubscriber(@RequestBody SubscriberDTO subscriberDTO) {
	logger.info("[Req] save subscriber {}", subscriberDTO);
	SubscriberDTO savedSubscriber = subscriberService.saveOrUpdate(subscriberDTO);
	logger.info("[Req] User is saved");
	return ResponseEntity.ok(savedSubscriber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriberDTO> findById(@PathVariable long id) {
	logger.info("[Req] find user by id {}", id);
	SubscriberDTO foundSubscriber = subscriberService.findById(id);
	logger.info("[Req] User is found");
	return ResponseEntity.ok(foundSubscriber);
    }

    @GetMapping("/{idSub}/contract")
    public List<ContractDTO> getContractList(@PathVariable long idSub) {
	logger.info("[Req] find user by id {}", idSub);
	List<ContractDTO> contracts = contractService.findBySubscriberId(idSub);
	logger.info("[Req] User is found");
	return contracts;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable long id, @RequestBody AddressDTO addressDTO) {
	logger.info("[Req] update subscriber's {} with new address {}", id, addressDTO);

	SubscriberDTO subscriberDTO = subscriberService.updateSubscriberAddress(id, addressDTO);
	logger.info("Subscriber's address {} is updated", id);

	eventPublisher.publishEvent(new OnAddressChangeEvent(subscriberDTO));

	logger.info("add movment: Subscriber's address updated");
	return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
