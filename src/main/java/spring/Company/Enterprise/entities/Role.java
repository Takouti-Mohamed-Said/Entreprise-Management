package spring.Company.Enterprise.entities;


import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	   
	@Id
	private int id;
	private String chefDepartement;
	private String administrateur;
	private String ingenieur;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getChefDepartement() {
		return this.chefDepartement;
	}

	public void setChefDepartement(String chefDepartement) {
		this.chefDepartement = chefDepartement;
	}   
	public String getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(String administrateur) {
		this.administrateur = administrateur;
	}   
	public String getIngenieur() {
		return this.ingenieur;
	}

	public void setIngenieur(String ingenieur) {
		this.ingenieur = ingenieur;
	}
   
}
