package org.launchcode.techjobs.persistent.controllers;
/*TODO: Add a SkillController class and replicate the steps when creating the EmployerController
         Needs to have the method:
         index()
         displayAddSkillForm()
         processAddSkillFOrm()
         displayViewSkill
         All should behave exactly the same as the corresponding methods in the EmployerController*/

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "All Skill");
        model.addAttribute("skill", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute("title", "Add Skill");
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        }
        skillRepository.save(newSkill);

        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId){
       Optional<Skill> optSkill = skillRepository.findById(skillId);
       if(optSkill.isPresent()) {
           Skill skill = (Skill) optSkill.get();
           model.addAttribute("skill", skill);
           return "skill/view";
       }else{
           return "redirect:../";
       }
    }



}
