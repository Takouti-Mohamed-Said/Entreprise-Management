package spring.Company.Enterprise.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.Company.Enterprise.entities.Enterprise;

@Repository("EntrepriseRepository")
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>{

}