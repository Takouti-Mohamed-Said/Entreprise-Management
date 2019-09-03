package spring.Company.Enterprise.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mission
 *
 */
@Entity

public class Mission implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	@OneToMany (mappedBy="mission")
	private List<TimeSheet> timesheet;	
	public Mission() {
		super();
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
