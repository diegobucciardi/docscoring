package com.dab.docscoring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dab.docscoring.hibernate.model.DocumentValidation;

@Repository
@SuppressWarnings("unchecked")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ScoringDAO{

	private final String GET_MINIMUM_QUERY = "select value from minimums_acceptable m where m.id_company = :companyId and m.id_doc_type = :documentId";
	private final String GET_VALIDATIONS_QUERY="SELECT v.ID, v.DESCRIPTION, s.PERCENTAGE FROM document_validations v, validations_scoring s "+
			"where v.DOCUMENT_TYPE_ID = :documentId and s.id_company = :companyId "+
			"and s.id_doc_validation = v.ID";
	
	@Autowired 
	protected SessionFactory sessionFactory;
	
	@Transactional
	public List<DocumentValidation> getValidations(int companyId, int documentId) {
		Session session = sessionFactory.getCurrentSession();
		List<DocumentValidation> result = session.createSQLQuery(GET_VALIDATIONS_QUERY).addEntity(DocumentValidation.class)
				.setInteger("companyId", companyId).setInteger("documentId", documentId).list();
	    return (List<DocumentValidation>) result;
	}
	
	@Transactional
	public Integer getMinimumAcceptable(int companyId, int documentId){
		Session session = sessionFactory.getCurrentSession();
		Object result = session.createSQLQuery(GET_MINIMUM_QUERY).setInteger("companyId", companyId).setInteger("documentId", documentId).uniqueResult();
	    return (Integer)result;
	}
}