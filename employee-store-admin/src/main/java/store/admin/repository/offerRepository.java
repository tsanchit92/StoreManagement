package store.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.admin.entity.offers;

@Repository
public interface offerRepository  extends JpaRepository<offers, Integer>{

}
