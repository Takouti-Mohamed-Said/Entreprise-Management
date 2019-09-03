package spring.Company.Enterprise.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Company.Enterprise.entities.Role;


@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

}