package sn.groupeisi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Inscription  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String details;
	@ManyToOne
	@JoinColumn(name="Student_ID")
	private Student student = new Student();
	//List<Student > student= new ArrayList<Student>(); 
	@ManyToOne
	@JoinColumn(name="Courses_ID")
	private Coures coures =new Coures();
	//List< Coures> coures= new ArrayList<Coures>(); 
	@ManyToOne
	@JoinColumn(name="Year_ID")
	//List< Year> years = new ArrayList<Year>(); 
	private Year years =new Year();
	

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getDetails() {return details;}
	public void setDetails(String details) {this.details = details;}
	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student = student;}
	public Coures getCourses() {return coures;}
	public void setCourses(Coures courses) {this.coures = courses;}
	public Year getYears() {return years;}
	public void setYears(Year years) {this.years = years;}
	
	
	
}
