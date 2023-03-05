package sn.groupeisi.interfaces;

import jakarta.ejb.Local;

import sn.groupeisi.entities.Student;
@Local
public interface Istudent extends Repository<Student> {

	Student getStudentById(int idstudent);

}
