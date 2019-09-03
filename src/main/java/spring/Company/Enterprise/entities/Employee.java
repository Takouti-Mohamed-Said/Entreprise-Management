package spring.Company.Enterprise.entities;


import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String isActive;
	private String role;
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Contract contract;
	@ManyToMany
	private List<Departement> departments;
	@OneToMany(mappedBy="Employee")
	private List<TimeSheet> timesheet;
	@ManyToOne
	@JsonIgnore
	private Enterprise enterprise;
	
	
	public Employee() {
		super();
	} 
	
	
	public Enterprise getEnterprise() {
		return enterprise;
	}


	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}


	public void setContract(Contract contract) {
		this.contract = contract;
	}


	public Contract getContract() {
		return contract;
	}

	public void setContrat(Contract contract) {
		this.contract = contract;
	}

	public List<Departement> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Departement> departments) {
		this.departments = departments;
	}

	public List<TimeSheet> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(List<TimeSheet> timesheet) {
		this.timesheet = timesheet;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
}
