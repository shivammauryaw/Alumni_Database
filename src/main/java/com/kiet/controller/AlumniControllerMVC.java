package com.kiet.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kiet.model.Alumni;
import com.kiet.service.AlumniService;

@Controller
public class AlumniControllerMVC {
    
    private final AlumniService service;

    public AlumniControllerMVC(AlumniService service) {
        this.service = service;
    }
    
    // Main page with optional batch filtering
    @GetMapping({"/", "/alumni"})
    public String getAllAlumni(Model model, 
                             @RequestParam(required = false) String batch) {
        List<Alumni> alumniList = (batch != null && !batch.isEmpty()) 
            ? service.retrieveByBatch(batch) 
            : service.retrieveAll();
        
        model.addAttribute("alumniList", alumniList);
        model.addAttribute("batches", service.getAllBatches());
        model.addAttribute("selectedBatch", batch);
        return "index";
    }
    
    // View single alumni - distinct path with {id}
    @GetMapping("/alumni/view/{id}")
    public String viewAlumni(Model model, @PathVariable int id) {
        model.addAttribute("alumni", service.retrieveById(id));
        return "single";
    }
    
    // Add new alumni form - distinct path
    @GetMapping("/alumni/add")
    public String showAddForm(Model model) {
        model.addAttribute("alumni", new Alumni());
        return "update";
    }
    
    // Edit existing alumni - distinct path with {id}
    @GetMapping("/alumni/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        model.addAttribute("alumni", service.retrieveById(id));
        return "update";
    }
    
    // Handle form submission - POST to distinct path
    @PostMapping("/alumni/save")
    public String saveAlumni(@ModelAttribute Alumni alumni) {
        service.addFeedback(alumni);
        return "redirect:/";
    }
    
    // Delete alumni - distinct path with {id}
    @GetMapping("/alumni/delete/{id}")
    public String deleteAlumni(@PathVariable int id) {
        service.removebyid(id);
        return "redirect:/";
    }
}