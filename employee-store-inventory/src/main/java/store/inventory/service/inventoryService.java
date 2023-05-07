package store.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.inventory.entity.Item;
import store.inventory.repository.inventoryRepo;

@Service
public class inventoryService {
	
	@Autowired
	inventoryRepo repo;
	
	public void addItem(Item item)
	{
		repo.save(item);
	}

	public void addQuantity(int id, int quantity) {
		Item item = repo.findById(id).get();
		int leftStock = item.getQuantityInStock();
		item.setQuantityInStock(quantity+leftStock);
		repo.save(item);
	}
	
	public void deleteItem(int id )
	{
		repo.deleteById(id);
	}
	
	public List<Item> getInventory()
	{
		return repo.findAll();
	}
	
	public List<Item> getInventoryWith100orLess()
	{
		return repo.findItemLessThan100();
	}
	

	public List<Item> getInventoryWith50orLess()
	{
		return repo.findItemLessThan50();
	}

	public List<Item> getInventoryWith10orLess()
	{
		return repo.findItemLessThan10();
	}
	
	public List<Item> getInventoryWithNoStock()
	{
		return repo.findItemNoStock();
	}

}
