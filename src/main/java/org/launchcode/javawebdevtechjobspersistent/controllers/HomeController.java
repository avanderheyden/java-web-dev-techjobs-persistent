package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
//        model.addAttribute("title", "Add Skills");
//        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
//            model.addAttribute("skills", skillRepository.findAll());
            return "add";
        } else {
            Optional<Employer> result = employerRepository.findById(employerId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Employer ID: " + employerId);
            } else {
                Employer employer = result.get();
                model.addAttribute("title", "Results for " + employer.getName());
//                model.addAttribute("employers", employer.get( new Job());
                if (errors.hasErrors()) {
                    model.addAttribute("skills", skillRepository.findAll());
                    return "add";
                } else {
                List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
                newJob.setSkills(skillObjs);
             }
            }
            return "redirect:";
        }
    }

        @GetMapping("view/{jobId}")
        public String displayViewJob (Model model,@PathVariable int jobId){

            return "view";
        }
    }

//what I had before for processAddJobForm
//@PostMapping("add")
//public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
//
//    if (errors.hasErrors()) {
//        model.addAttribute("title", "Add Job");
//        model.addAttribute("employer", employerRepository.findAll());
//        return "add";
//    }
//    else {
//        employerRepository.findById(employerId);
//    }
//
//    return "redirect:";
//}