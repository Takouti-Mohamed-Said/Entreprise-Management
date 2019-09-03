package spring.Company.Enterprise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.Company.Enterprise.entities.Contract;


@Repository("ContractRepository")
public interface ContractRepository extends JpaRepository<Contract, Integer>{

}