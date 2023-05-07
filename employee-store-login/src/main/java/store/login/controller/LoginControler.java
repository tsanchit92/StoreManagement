package store.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.login.entity.AppUser;
import store.login.entity.Role;
import store.login.service.loginService;

@RestController
@RequestMapping("/api")
public class LoginControler {

	@Autowired
	loginService service;

	@PostMapping("/saveUser")
	public AppUser saveUser(AppUser user) {
		return service.saveUser(user);
	}

	@PostMapping("/saveRole")
	public Role saveRole(Role role) {
		return service.saveRole(role);
	}

	@PostMapping("/addRole")
	public void addRole(String userName, String roleName)
	{
		service.addRole(userName, roleName);
	}
	@GetMapping("/refreshToken")
	public void refershToken(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		service.getRefreshToken(request,response);
	}

}
