package com.alviszalamans.survey.web.controllers;

import com.alviszalamans.survey.data.entity.Application;
import com.alviszalamans.survey.data.entity.Sector;
import com.alviszalamans.survey.data.entity.SmallSector;
import com.alviszalamans.survey.data.processors.SectorProcessor;
import com.alviszalamans.survey.data.repository.ApplicationRepository;
import com.alviszalamans.survey.data.repository.SectorRepository;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class SurveyController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private SectorRepository sectorRepository;


    @Autowired
    private SectorProcessor sectorProcessor;

    List<SmallSector> nestedSectors;


    @GetMapping
    public String getForm(Model model, HttpSession session) {
        List<SmallSector> nestedSectors = new ArrayList<>();
        if (nestedSectors.isEmpty()){
            nestedSectors = sectorProcessor.getNestedSectors();
        }
        session.setAttribute("id",0L);
        model.addAttribute("sectorsList", nestedSectors);
        model.addAttribute("application", new Application());
        return "survey";
    }

    @PostMapping
    public String sendSurvey(@Valid @ModelAttribute("application") Application app, BindingResult bindingResult, HttpSession session, Model model){
        model.addAttribute("sectorsList", nestedSectors);
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
