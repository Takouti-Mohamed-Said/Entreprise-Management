package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.Contract;


public interface ContractService {

	public List<Contract> getAll();
	
	public Contract addContract(Contract c);
	
	public void deleteContract(Contract c);
	
	public void updateContract(Contract c);
	
	public Contract findContractById(Contract c);

	List<Contract> listContracts();
	
}
 