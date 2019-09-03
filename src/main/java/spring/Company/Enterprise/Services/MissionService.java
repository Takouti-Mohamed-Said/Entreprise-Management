package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.Mission;


public interface MissionService {

	public List<Mission> getAll();
	
	public Mission addMission(Mission m);
	
	public void deleteMission(Mission m);
	
	public void updateMission(Mission m);
	
	public Mission findMissionById(Mission m);

	List<Mission> listMissions();
	
}
 