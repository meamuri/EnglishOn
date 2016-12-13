package edu.jschool.enon.controller;

import edu.jschool.enon.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "", method = GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("words", wordService.getAll());
        return "";
    }
}
