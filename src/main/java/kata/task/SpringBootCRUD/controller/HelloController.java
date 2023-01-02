package kata.task.SpringBootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import kata.task.SpringBootCRUD.model.User;
import kata.task.SpringBootCRUD.service.UserService;

import java.util.List;

@Controller
public class HelloController {
	@Autowired
	private UserService uService;

	@GetMapping(value = "/")
	public String usersList(ModelMap model) {
		List<User> users = uService.getAllUsers();
		model.addAttribute("users", users);
		return "usersList";
	}

	@GetMapping(value = "/newUser")
	public String addUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUserForm";
	}

	@RequestMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		uService.saveUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/updateUser/{id}")
	public String updateUser(@PathVariable(name = "id") int id, ModelMap model) {
		User user = uService.getUser(id);
		model.addAttribute("user", user);
		return "addUserForm";
	}

	@RequestMapping(value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		uService.deleteUser(id);
		return "redirect:/";
	}
	
}