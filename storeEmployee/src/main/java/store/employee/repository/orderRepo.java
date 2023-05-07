
package store.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.employee.entity.Order;

@Repository
public interface orderRepo extends JpaRepository<Order, Integer> {

}
