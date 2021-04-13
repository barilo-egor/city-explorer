package by.resliv.cityexplorerrestweb.controller;

import by.resliv.cityexplorercore.bean.City;
import by.resliv.cityexplorercore.exception.CityAlreadyExistException;
import by.resliv.cityexplorercore.exception.CityNotFoundException;
import by.resliv.cityexplorercore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CitiesController {
    private CityService cityService;

    @GetMapping("/cities/find/{name}")
    public ModelAndView find(@PathVariable String name, ModelAndView view) throws CityNotFoundException {
        City city = cityService.findByName(name);
        view.addObject("city", city);
        view.setViewName("city");
        return view;
    }

    @GetMapping("/cities/add")
    public ModelAndView add(ModelAndView view){
        view.setViewName("add");
        view.addObject("city", new City());
        return view;
    }

    @PostMapping("/cities/add")
    public String save(@ModelAttribute City city) throws CityAlreadyExistException {
        cityService.save(city);
        return "redirect:/";
    }

    @GetMapping("/cities/edit/{name}")
    public ModelAndView edit(@PathVariable String name, ModelAndView view){
        view.setViewName("edit");
        view.addObject("city", cityService.findByName(name));
        return view;
    }

    @PostMapping("/cities/edit/{id}")
    public String submitEdit(@ModelAttribute City city, @PathVariable long id) throws CityAlreadyExistException {
        city.setId(id);
        cityService.save(city);
        return "redirect:/";
    }

    @GetMapping("/cities/delete/{name}")
    public String delete(@PathVariable String name) throws CityNotFoundException{
        cityService.delete(cityService.findByName(name));
        return "redirect:/";
    }

    @ExceptionHandler({CityNotFoundException.class, CityAlreadyExistException.class})
    @GetMapping
    public ModelAndView handleError(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex.getMessage());
        mav.setViewName("error");
        return mav;
    }

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
}
