package store.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.admin.entity.employeeReg;

@Repository
public interface adminRepo extends JpaRepository<employeeReg, Long>{

}
