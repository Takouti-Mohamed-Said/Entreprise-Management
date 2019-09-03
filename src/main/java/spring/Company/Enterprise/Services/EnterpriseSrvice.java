package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.Enterprise;


public interface EnterpriseSrvice {

	public List<Enterprise> getAll();
	
	public Enterprise addEnterprise(Enterprise e);
	
	public void deleteEnterprise(Enterprise e);
	
	public void updateEnterprise(Enterprise e);
	
	public Enterprise findEnterpriseById(int idEntreprise);

	List<Enterprise> listEnterprises();
	
}
 