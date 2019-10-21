package spring.Company.Enterprise.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Entreprise
 *
 */
@Entity

public class Enterprise implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String raisonSocial;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="enterprise")
	private List<Employee> employees;
	
	
	
	public Enterprise() {
		super();
	}   
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getRaisonSocial() {
		return this.raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
   
}
