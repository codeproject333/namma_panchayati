package com.webpage.PanchayatiDashboard.controllers;

import com.webpage.PanchayatiDashboard.services.panchayatiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    panchayatiDataService panchayatdataservice;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("workdata", panchayatdataservice.getAllwork());
        return "home";
    }


}
