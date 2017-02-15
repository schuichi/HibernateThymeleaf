package pl.tomekD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tomekD.dao.PersonDao;
import pl.tomekD.model.Person;

import java.util.List;

/**
 * Created by Tomek on 2017-02-08.
 */
@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping("/person/all")
    public String all(ModelMap modelMap){
        modelMap.addAttribute("people", personDao.getAll());
        return "person/all";
    }

    @GetMapping("/person/search")
    public String search(ModelMap modelMap){
        modelMap.addAttribute("person", new Person());
        return "person/search";
    }

    @GetMapping("/person/{id}")
    public String delete(@PathVariable Long id, ModelMap modelMap){
        personDao.delete(id);
        modelMap.put("people", personDao.getAll());
        return "person/all";
    }

    @PostMapping("/person/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap){
        String surname = person.getSurname();
        List<Person> people = personDao.findBySurname(surname);
        modelMap.addAttribute("people", people);
        return "person/all";
    }

    @GetMapping("/person/add")
    public String add(ModelMap modelMap){
        modelMap.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/person/create")
    public String create(@ModelAttribute Person person, ModelMap modelMap){
        personDao.save(person);
        return "redirect:/person/success";
    }

    @GetMapping("/person/success")
    public String success(){
        return "/person/success";
    }
}
