package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sn.groupeisi.entities.Inscription;
import sn.groupeisi.interfaces.IInscription;

@Stateless
public class IscriptionImpl extends RepositoryImpl<Inscription> implements IInscription{
	@PersistenceContext(unitName="SchoolEJB")
	protected EntityManager em;
}
