package spring.Company.Enterprise.entities;


import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departement
 *
 */
@Entity

public class Departement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="departments")
	private List<Employee> Employee;
	
	public List<Employee> getEmployee() {
		return Employee;
	}
	public void setEmployee(List<Employee> employee) {
		Employee = employee;
	}
	public Departement() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
