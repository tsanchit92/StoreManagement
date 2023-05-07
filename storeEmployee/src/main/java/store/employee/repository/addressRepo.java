
package store.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.employee.entity.Address;

@Repository
public interface addressRepo extends JpaRepository<Address, Integer> {

}
