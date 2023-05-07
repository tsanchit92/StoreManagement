package store.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import store.login.entity.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long>{

	AppUser findByUsername(String userName);
}
