package com.covidtracker.covidtracker.controllers;


import com.covidtracker.covidtracker.models.LocationStats;
import com.covidtracker.covidtracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


     CoronaVirusDataService coronaVirusDataService;


     public String home(Model model){
         List<LocationStats> allStats = coronaVirusDataService.getAllStats();
         int totalReportedCases =allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
         int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
         model.addAttribute("locationStats",allStats);
         model.addAttribute("totalReportedCases", totalReportedCases);
         model.addAttribute("totalNewCases", totalNewCases);

         return "home";






    }
}
