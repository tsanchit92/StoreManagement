package store.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import store.admin.dto.Order;
import store.admin.entity.employeeReg;
import store.admin.entity.offers;
import store.admin.repository.adminRepo;
import store.admin.repository.offerRepository;

@Service
public class adminService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	adminRepo Arepo;

	@Autowired
	offerRepository Orepo;

	public void employeeRegister(employeeReg employee) {
		Arepo.save(employee);
	}

	public void employeeUpdate(employeeReg employee) {
		Arepo.save(employee);
	}

	public List<employeeReg> getAllEmployee() {
		return Arepo.findAll();
	}

	public employeeReg getEmployee(long phone) {
		return Arepo.findById(phone).orElseThrow();
	}

	public void newOffer(offers offer) {
		Orepo.save(offer);
	}
	 public List<offers> getAllOffers()
	 {
		return Orepo.findAll();
	 }
	public List<Order> getAllOrders() {

		List<Order> orders =new ArrayList<>();
		orders =webClientBuilder.build().get()
				.uri("/user/fetchOrders").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Order>>() {
				}).block();
		return orders;
	}
}
