package store.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import store.login.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>
{
  
	Role findByName(String name);
	
}
