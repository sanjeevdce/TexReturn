package com.altimetrik.texreturn.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.altimetrik.texreturn.domain.Taxreturn;

@Repository(value = "employeedao")
@Transactional
public class TaxReturnDAOImpl implements TaxReturnDAO{
	
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	@Override
	public void saveEmployee(Taxreturn taxreturn)
	{
		//List<Taxreturn> taxretList = sessionFactory.getCurrentSession().createQuery("from Taxreturn t").list();
		sessionFactory.getCurrentSession().save(taxreturn);
	}
	@Override
	public List<Taxreturn>  getTaxReturnDtls(String  name, String docType, String financialYear)
	{
		//List<Taxreturn> taxretList = sessionFactory.getCurrentSession().createQuery("from Taxreturn t").list();
		Query query=sessionFactory.getCurrentSession().createQuery("from Taxreturn taxreturn where taxreturn.name=:name and taxreturn.docType=:docType and taxreturn.financialYear=:financialYear");
		query.setString("name", name);
		query.setString("docType", docType);
		query.setString("financialYear", financialYear);
		List<Taxreturn>  taxreturnList = (List) query.list();
		return taxreturnList;
	}
	
	public List<Taxreturn>  getDisplayList(){
		/*Criteria criteria = 
				sessionFactory.getCurrentSession().createCriteria(Taxreturn.class)         
			           .setProjection(Projections.distinct(Projections.property("name")));*/
		Query query=sessionFactory.getCurrentSession().createQuery("from Taxreturn ");
		List<Taxreturn> raxreturnList =  query.list();
		return raxreturnList;
	}
	
	public List<String>  getNameList(){
		Criteria criteria = 
				sessionFactory.getCurrentSession().createCriteria(Taxreturn.class)         
			           .setProjection(Projections.distinct(Projections.property("name")));
		return criteria.list();
	}
	public List<String>  getDocTypeList(){
		Criteria criteria = 
				sessionFactory.getCurrentSession().createCriteria(Taxreturn.class)         
			           .setProjection(Projections.distinct(Projections.property("docType")));
		return criteria.list();
	}
	public List<String>  getFinYearList(){
		Criteria criteria = 
				sessionFactory.getCurrentSession().createCriteria(Taxreturn.class)         
			           .setProjection(Projections.distinct(Projections.property("financialYear")));
		return criteria.list();
	}
	
}
