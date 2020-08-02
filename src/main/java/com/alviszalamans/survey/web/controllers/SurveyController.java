package com.alviszalamans.survey.web.controllers;

import com.alviszalamans.survey.data.entity.Application;
import com.alviszalamans.survey.data.dto.SectorDto;
import com.alviszalamans.survey.data.service.SectorService;
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
import java.util.List;

@Controller
@RequestMapping("/")
public class SurveyController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private SectorService sectorService;

    @ModelAttribute("sectorsList")
    public List<SectorDto> getSectors() {
        return sectorService.getNestedSectors();
    }

    @GetMapping
    public String getForm(Model model, HttpSession session) {
        session.setAttribute("id",0L);
        model.addAttribute("application", new Application());
        return "survey";
    }

    @PostMapping
    public String sendSurvey(@Valid @ModelAttribute("application") Application app, BindingResult bindingResult, HttpSession session, Model model){
        Long id = (Long) session.getAttribute("id");
        if (!bindingResult.hasErrors()){
            model.addAttribute("success",true);
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
