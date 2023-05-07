
package store.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.employee.entity.user;

@Repository
public interface userRepo extends JpaRepository<user, Long> {

}
