package edu.jschool.enon.controller;

import edu.jschool.enon.component.YaTranslator;
import edu.jschool.enon.data.dto.CreateWordDto;
import edu.jschool.enon.data.dto.OnlySpellingCreateWordDto;
import edu.jschool.enon.data.dto.TextContainer;
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

import java.io.IOException;
import java.util.LinkedList;
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

    @RequestMapping(value = "/addWithApi", method = GET)
    public String getFormWhereUserCanAddOnlySpelling(ModelMap modelMap){
        return "word/addWithApi";
    }


    @RequestMapping(value = "/addWithApi", method = POST)
    public String translateAndAddWord (
            @ModelAttribute("word") @Validated OnlySpellingCreateWordDto word,
            BindingResult bindingResult, ModelMap modelMap){

        if (bindingResult.hasErrors()){
            List<ValidationErrorDto> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map ((x) -> new ValidationErrorDto(x.getField(), x.getDefaultMessage()))
                    .collect(Collectors.toList());
            modelMap.addAttribute("validationsErrors", errors);
            return "redirect:/addWithApi";
        }

        YaTranslator translator = new YaTranslator();

        String spelling = word.getSpelling();
        String value = translator.springApiTranslate(spelling);

        CreateWordDto the_word = new CreateWordDto();
        the_word.setSpelling(spelling);
        the_word.setValueInLanguage(value);

        wordService.save(the_word);
        return "redirect:/";
    }

    @RequestMapping(value = "/addText", method = GET)
    public String getFormForText(ModelMap modelMap){
        return "word/addText";
    }

    @RequestMapping(value = "/checkText", method = POST)
    public String checkText(@ModelAttribute("text") @Validated TextContainer text,
                            BindingResult bindingResult, ModelMap modelMap) {
        String s1 = text.getText();
        return "redirect:/";
    }

}
