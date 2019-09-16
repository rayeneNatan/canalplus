package com.canalplus.blueprint.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.canalplus.blueprint.domain.Address;

public class AddressSearchRepositoryImpl implements AddressSearchRepository {

    protected final Logger log = LogManager.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    private static final String COUNTRY = "country";
    private static final String STATE = "state";
    private static final String CITY = "city";
    private static final String ZIP = "zip";
    private static final String NUMBER = "number";
    private static final String TYPE = "type";

    @SuppressWarnings("unchecked")
    @Override
    public List<Address> addressFuzzySearch(String searchTerm) {

	javax.persistence.Query jpaQuery = createJpaQuery(searchTerm);

	List<Address> addresses = null;
	/* execute search */
	try {
	    addresses = jpaQuery.getResultList();
	} catch (NoResultException nre) {
	    log.error("An error occurred while getting result of address search: {} ", nre);

	}
	return addresses;
    }

    private javax.persistence.Query createJpaQuery(String searchTerm) {
	FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
		.getFullTextEntityManager(entityManager);

	/* create native Lucene query using the query DSL */
	QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Address.class).get();

	org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields(COUNTRY, STATE, CITY, ZIP, NUMBER, TYPE)
		.matching(searchTerm).createQuery();

	return fullTextEntityManager.createFullTextQuery(luceneQuery, Address.class);
    }

}
