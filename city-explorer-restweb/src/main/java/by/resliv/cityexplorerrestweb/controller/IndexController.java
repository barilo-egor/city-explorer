package by.resliv.cityexplorerrestweb.controller;

import by.resliv.cityexplorercore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
    private CityService cityService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView model){
        model.addObject("cities", cityService.findAll());
        model.setViewName("index");
        return model;
    }

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
}
