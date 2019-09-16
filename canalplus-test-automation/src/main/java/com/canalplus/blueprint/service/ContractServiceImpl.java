package com.canalplus.blueprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canalplus.blueprint.domain.Contract;
import com.canalplus.blueprint.dto.ContractDTO;
import com.canalplus.blueprint.mapper.ContractMapper;
import com.canalplus.blueprint.repository.ContractRepository;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    ContractMapper contractMapper;

    @Override
    public List<ContractDTO> findBySubscriberId(Long id) {
	List<Contract> contracts = contractRepository.findBySubscriberId(id);
	return contractMapper.toDto(contracts);
    }

    
   
}
