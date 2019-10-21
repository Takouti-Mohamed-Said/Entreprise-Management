package spring.Company.Enterprise.entities;

import java.io.Serializable;
import java.lang.Integer; 
import java.util.List;

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
	private String dateDebut;
	private String dateFin;
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn(name="idEmployee", referencedColumnName="id")
	private Employee Employee;

	@ManyToOne
	@JoinColumn(name="idemission", referencedColumnName="id")
	private Mission mission;
	
	/*private List<Employee> employees;
	private List<Mission> missions;
	*/
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
	public String getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public String getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/*public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}*/
   
}
