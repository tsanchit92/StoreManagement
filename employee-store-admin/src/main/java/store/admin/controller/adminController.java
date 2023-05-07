package store.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.admin.dto.Order;
import store.admin.entity.employeeReg;
import store.admin.entity.offers;
import store.admin.service.adminService;

@RestController
@RequestMapping("/store/admin")
public class adminController {

	
	@Autowired
	adminService service;
	
	@PostMapping("/employeeReg")
	public void employee(@RequestBody employeeReg employee)
	{
		service.employeeRegister(employee);
	}
	
	@GetMapping("/employeeDetails/{phone}")
	public employeeReg getEmployee(@PathVariable Long phone)
	{
		return service.getEmployee(phone);
	}
	
	@GetMapping("/employees")
	public List<employeeReg> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@PostMapping("/offers")
	public void newOffer(@RequestBody offers offer)
	{
		service.newOffer(offer);
	}
	
	@PutMapping("/employeeDetails/update")
	public void updateEmployee(@RequestBody employeeReg employee)
	{
		service.employeeUpdate(employee);
	}
	
	@GetMapping("/getAll/Orders")
	public List<Order> getAllOrders()
	{
		return service.getAllOrders();
	}
	
	@GetMapping("/getAll/Offers")
	public List<offers> getAllOffers()
	{
		return service.getAllOffers();
	}
}

