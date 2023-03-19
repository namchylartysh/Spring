package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.domain.Person;
import spring.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "index";
    }
    @GetMapping("/add")
    public String add(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("person") Person person) {
        personService.add(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final Integer id) {
        personService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Integer id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("person") Person person) {
        personService.edit(person.getId(), person);
        return "redirect:/";
    }
}
