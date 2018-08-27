package pl.techstyle.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.techstyle.Model.Person;
import pl.techstyle.Service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService service;
	
	@GetMapping("/")
	public ModelAndView getMainPage() {
		ModelAndView m= new ModelAndView();
		m.addObject("persons",service.getAll());
		m.setViewName("index");
		return m;
	}
	
	@GetMapping("/person")
	public ModelAndView getPerson(@RequestParam(value="id") int id) {
		ModelAndView m= new ModelAndView();
		m.addObject("person",service.getPerson(id));
		m.setViewName("edit");
		return m;
	}
	@PutMapping("/person")
	public ModelAndView setPerson(@Valid Person p) {
		ModelAndView m= new ModelAndView();
		System.out.println(p.toString());
		service.editPerson(p);
		m.addObject("persons",service.getAll());
		m.setViewName("index");
		return m;
	}
}
