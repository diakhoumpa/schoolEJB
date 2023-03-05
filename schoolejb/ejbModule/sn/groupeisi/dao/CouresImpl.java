package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Coures;
import sn.groupeisi.interfaces.Icoures;
@Stateless
public class CouresImpl extends RepositoryImpl<Coures> implements Icoures{
	@PersistenceContext(unitName="SchoolEJB")
	protected EntityManager em;

	@Override
	public Coures getCouresById(int icours) {
		 return em.find(Coures.class,  icours);
	}
}
