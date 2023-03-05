package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Student;
import sn.groupeisi.interfaces.Istudent;

@Stateless
public class StudentImpl extends RepositoryImpl<Student>implements Istudent{
	@PersistenceContext(unitName="SchoolEJB")
	protected EntityManager em;

	@Override
	public Student getStudentById(int idstudent) {
		
		return em.find(Student.class,  idstudent);
	}
}
