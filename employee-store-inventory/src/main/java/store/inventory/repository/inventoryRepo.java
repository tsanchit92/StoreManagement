package store.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import store.inventory.entity.Item;

@Repository
public interface inventoryRepo extends JpaRepository<Item, Integer>{

	@Query("Select u from Item where u.quantity <= 100")
	public List<Item> findItemLessThan100();
	
	@Query("Select u from Item where u.quantity <= 50")
	public List<Item> findItemLessThan50();
	
	@Query("Select u from Item where u.quantity <= 10")
	public List<Item> findItemLessThan10();
	
	@Query("Select u from Item where u.quantity = 0")
	public List<Item> findItemNoStock();
	
}
