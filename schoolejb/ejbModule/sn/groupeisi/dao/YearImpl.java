package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Year;
import sn.groupeisi.interfaces.Iyear;
@Stateless
public class YearImpl extends RepositoryImpl<Year>implements Iyear {
	@PersistenceContext(unitName="SchoolEJB")
	protected EntityManager em;

	@Override
	public Year getYearById(int iyears) {
		// TODO Auto-generated method stub
		return em.find(Year.class,  iyears);
	}
}
