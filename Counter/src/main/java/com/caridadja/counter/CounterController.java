package com.caridadja.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("count") == null) {
		session.setAttribute("count", 1);
		}
		else {
			Integer counter = (Integer) session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		return "home.jsp";
	}
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if(session.getAttribute("count") == null) {
			model.addAttribute("counter", 0);
		}
		else {
		model.addAttribute("counter", session.getAttribute("count"));
		}
		return "counter.jsp";
	}
}
