package spring.Company.Enterprise.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TimeSheet
 *
 */
@Entity

public class TimeSheet implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn(name="idEmployee", referencedColumnName="id",insertable=false,updatable=false)
	private Employee Employee;
	
	
	@ManyToOne
	@JoinColumn(name="idemission", referencedColumnName="id",insertable=false,updatable=false)
	private Mission mission;
	public TimeSheet() {
		super();
	}   
	
	public Employee getEmployee() {
		return Employee;
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
   
}
