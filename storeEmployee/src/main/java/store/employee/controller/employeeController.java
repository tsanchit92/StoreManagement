package store.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.employee.dto.Item;
import store.employee.dto.employee;
import store.employee.entity.Order;
import store.employee.entity.user;
import store.employee.service.employeeService;

@RestController
@RequestMapping("/store/employee")
public class employeeController {

	@Autowired
	employeeService emps;

	@PostMapping("/user/register")
	public void registerUser(@RequestBody user u1) {
		emps.registerUser(u1);
	}

	@GetMapping("/employee/{phone}")
	public employee getEmployee(@PathVariable long phone) {
		return emps.getEmployee(phone);
	}

	@GetMapping("/inventory/getProductDetails/{id}")
	public Item getProductDetails(@PathVariable String id) {
		return emps.getProductDetails(id);
	}

	@GetMapping("/user/fetchUser/{phone}")
	public user getUser(@PathVariable long phone) {
		return emps.fetchUser(phone);
	}
	
	@GetMapping("/user/fetchOrders")
	public List<Order> getAllOrders()
	{
		return emps.getAllOrders();
	}
}
