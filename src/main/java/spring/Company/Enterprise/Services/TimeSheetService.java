package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.TimeSheet;

public interface TimeSheetService {

	public List<TimeSheet> getAll();
	
	public TimeSheet addTimeSheet(TimeSheet t);
	
	public void deleteTimeSheet(TimeSheet t);
	
	public void updateTimeSheet(TimeSheet t);
	
	public TimeSheet findTimeSheetById(int idT);

	List<TimeSheet> listTimeSheet();


	
}
 