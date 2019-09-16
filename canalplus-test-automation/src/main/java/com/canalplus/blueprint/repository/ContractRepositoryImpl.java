package com.canalplus.blueprint.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canalplus.blueprint.domain.Contract;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    protected final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    protected Session getSession() {
	return (Session) entityManager.getDelegate();
    }

    @Override
    public Optional<Contract> saveOrUpdate(Contract contract) {
	log.debug("[saveOrUpdate Contract]: {}", contract);
	getSession().saveOrUpdate(contract);
	entityManager.flush();
	return Optional.ofNullable(contract);
    }

    @Override
    public Optional<Contract> findById(Long id) {
	log.debug("[find Contract By Id]: {}", id);
	Contract contract = getSession().get(Contract.class, id);
	return Optional.ofNullable(contract);
    }

    @Override
    public List<Contract> findBySubscriberId(Long id) {
	/* Get the Criteria Builder */
	CriteriaBuilder builder = getSession().getCriteriaBuilder();

	/* Create Criteria */
	CriteriaQuery<Contract> criteria = builder.createQuery(Contract.class);

	Root<Contract> contractRoot = criteria.from(Contract.class);

	return entityManager
		.createQuery(criteria.select(contractRoot).where(builder.equal(contractRoot.get("subscriber"), id)))
		.getResultList();

    }

}
