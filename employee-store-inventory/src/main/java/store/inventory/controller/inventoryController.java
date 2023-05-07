package store.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.inventory.entity.Item;
import store.inventory.service.inventoryService;

@RestController
@RequestMapping("/store/inventory")
public class inventoryController {
	
	@Autowired
	inventoryService service;

	@GetMapping("/addItem")
	public void addItem(Item item)
	{
		service.addItem(item);
	}
	
	@GetMapping("/addQuantity")
	public void addQuantity(int id,int quantity)
	{
		service.addQuantity(id,quantity);
	}
	
	@GetMapping("/deleteItem")
	public void deleteItem(int id )
	{
		service.deleteItem(id);
	}
	
	@GetMapping("/getstockslessthan100")
	public void getstockslessthan100()
	{
		service.getInventoryWith100orLess();
	}
	
	@GetMapping("/getstockslessthan50")
	public void getstockslessthan50()
	{
		service.getInventoryWith50orLess();
	}
	
	@GetMapping("/getstockslessthan10")
	public void getstockslessthan10()
	{
		service.getInventoryWith10orLess();
	}
	
	@GetMapping("/getEmptyStocks")
	public void getEmptyStocks()
	{
		service.getInventoryWithNoStock();
	}
	
	@GetMapping("/getAllInventory")
	public void getAlInventory()
	{
		service.getInventory();
	}
}
