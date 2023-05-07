package store.employee.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import store.employee.dto.Item;
import store.employee.dto.employee;
import store.employee.entity.Order;
import store.employee.entity.cart;
import store.employee.entity.user;
import store.employee.repository.addressRepo;
import store.employee.repository.orderRepo;
import store.employee.repository.userRepo;

@Service
public class employeeService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	userRepo userR;

	@Autowired
	orderRepo orderR;

	@Autowired
	addressRepo addressR;

	List<Order> orders = new ArrayList<>();

	public void registerUser(user u1) {
		userR.save(u1);
	}

	public user fetchUser(long phone) {
		return userR.findById(phone).orElseThrow();
	}

	public employee getEmployee(long phone) {
		employee emp = webClientBuilder.build().get().uri("url1").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(new ParameterizedTypeReference<employee>() {
				}).block();
		return emp;

	}

	public Item getProductDetails(String id) {
		Item item = webClientBuilder.build().get().uri("url2/{id}").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Item>() {
				}).block();
		return item;
	}

	public List<Order> getAllOrders() {
		return orderR.findAll();
	}

	public void paymentSuccessfull(List<cart> carts, long phone, long totalBill) {
		user User = userR.findById(phone).get();
		Date date = new Date(System.currentTimeMillis());

		for (int i = 0; i < carts.size(); i++) {
			Order order = new Order(date, carts.get(i), User);
			orders.add(order);
		}
		User.setOrder(orders);
		userR.save(User);
	}

}
