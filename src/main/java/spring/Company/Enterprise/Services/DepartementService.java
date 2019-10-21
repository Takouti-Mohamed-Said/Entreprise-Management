package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.Departement;




public interface DepartementService {

	public List<Departement> getAll();
	
	public Departement addDepartement(Departement d);
	
	public void deleteDepartement(Departement d);
	
	public void updateDepartement(Departement d);
	
	public Departement findDepartementById(int idD);

	List<Departement> listDepartements();
	
}
 