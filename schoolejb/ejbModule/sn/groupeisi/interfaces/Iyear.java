package sn.groupeisi.interfaces;

import jakarta.ejb.Local;

import sn.groupeisi.entities.Year;
@Local
public interface Iyear extends Repository<Year> {

	Year getYearById(int iyears);

}
