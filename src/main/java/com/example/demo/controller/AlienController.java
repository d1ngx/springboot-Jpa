package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@DeleteMapping("alien/{aid}")
	public  String deleteAlien(@PathVariable int aid){
	    Alien alien = repo.getOne(aid);
	    repo.delete(alien);
	    return  "done";
    }

	@PostMapping(path = "/alien",consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());

		/*System.out.println(repo.findByLang("Java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByLangSorted("Java"));*/
		mv.addObject(alien);
		return mv;
	}

	@GetMapping("/aliens")
	//@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}

    @PutMapping(path = "/alien",consumes = {"application/json"})
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien2(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
}
