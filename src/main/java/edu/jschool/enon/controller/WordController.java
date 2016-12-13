package edu.jschool.enon.controller;

import edu.jschool.enon.data.dto.CreateWordDto;
import edu.jschool.enon.data.dto.ValidationErrorDto;
import edu.jschool.enon.entity.Word;
import edu.jschool.enon.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(value = "", method = GET)
    public String index(ModelMap modelMap){
        List<Word> list =  wordService.getAll();
        modelMap.addAttribute("words", list);
        return "word/index";
    }

    @RequestMapping(value = "/add", method = GET)
    public String getFormWhereUserCanAddWord(ModelMap modelMap){
        return "word/addWord";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addWord(@ModelAttribute("word") @Validated CreateWordDto word,
                          BindingResult bindingResult,
                          ModelMap modelMap){
        if (!bindingResult.hasErrors()){
            wordService.save(word);
            return "redirect:/";
        }
        // условие инвертировано: корокая и более понятная ветвь добавлена внутрь if
        List<ValidationErrorDto> errors = bindingResult
                .getFieldErrors()
                .stream()
                .map ((x) -> new ValidationErrorDto(x.getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());
        modelMap.addAttribute("validationsErrors", errors);
        return "redirect:/add";
    }
}
