package sn.groupeisi.interfaces;

import jakarta.ejb.Local;

import sn.groupeisi.entities.Coures;
@Local
public interface Icoures extends Repository<Coures>{

	Coures getCouresById(int icours);

}
