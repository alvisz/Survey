package com.alviszalamans.survey.web.controllers;

import com.alviszalamans.survey.data.entity.Application;
import com.alviszalamans.survey.data.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SurveyController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public String survey(Model model, HttpSession session) {
        session.setAttribute("id",0L);
        model.addAttribute("application", new Application());
        return "survey";
    }

    @PostMapping
    public String send(@Valid @ModelAttribute("application") Application app, BindingResult bindingResult, HttpSession session){
        Long id = (Long) session.getAttribute("id");
        if (!bindingResult.hasErrors()){
            if ((Long) session.getAttribute("id") == 0L){
                Long newId = applicationRepository.save(app).getResultId();
                session.setAttribute("id", newId);
            } else {
                if (applicationRepository.findById(id).isPresent()){
                    app.setResultId(id);
                    applicationRepository.save(app);
                }

            }

        }
        return "survey";
    }


}
