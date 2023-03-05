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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Student  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	@Column
	private String phone;
	@OneToMany(mappedBy="student", targetEntity = Inscription.class)
	private List<Inscription> inscription= new ArrayList<Inscription>();
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public Date getBirthdate() {return birthdate;}
	public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public List<Inscription> getInscription() {return inscription;}
	public void setInscription(List<Inscription> inscription) {this.inscription = inscription;}
	

}
