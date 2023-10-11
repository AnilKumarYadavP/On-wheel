package org.efood.restraunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
@GetMapping("/")
public String LoadMain()
{
	return "Main";
}
@GetMapping("/logout")
public String logout(HttpSession session, ModelMap map) {
	session.invalidate();
	map.put("pos", "Logout Success");
	return "Main";
}
}
