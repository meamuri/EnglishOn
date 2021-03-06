package edu.jschool.enon.controller;

import edu.jschool.enon.component.YaTranslator;
import edu.jschool.enon.data.dto.*;
import edu.jschool.enon.entity.Word;
import edu.jschool.enon.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;
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

    @RequestMapping(value = "/statistics", method = GET)
    public String dearCanYouGiveMeStatistics(ModelMap modelMap){
        List<Word> list =  wordService.getAll();
        modelMap.addAttribute("words", list);
        return "word/statistics";
    }


    @RequestMapping(value = "/add", method = POST)
    public String addWord(@ModelAttribute("word") @Validated CreateWordDto word,
                          BindingResult bindingResult,
                          ModelMap modelMap){
        if (bindingResult.hasErrors()){
            return redirectIfWeHaveErrors(bindingResult, modelMap, "add");
        }
        wordService.save(word);
        return "redirect:/";
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
            return redirectIfWeHaveErrors(bindingResult, modelMap, "addWithApi");
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
        if (bindingResult.hasErrors()){
            return redirectIfWeHaveErrors(bindingResult, modelMap, "checkText");
        }

        return "redirect:/" + addTextIfPossible(text.getText());
    }

    private String addTextIfPossible(String sourceText){
        YaTranslator translator = new YaTranslator();

        List<CreateWordDto> list = new LinkedList<>();
        String[] words = sourceText.split(" |\r\n");
        for (String word: words) {
            list.add(new CreateWordDto(word, translator.springApiTranslate(word)));
        }
        for (CreateWordDto word: list){
            wordService.save(word);
        }
        return "";
    }

    private String redirectIfWeHaveErrors(
            BindingResult bindingResult,
            ModelMap modelMap,
            String page){
        List<ValidationErrorDto> errors = bindingResult
                .getFieldErrors()
                .stream()
                .map ((x) -> new ValidationErrorDto(x.getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());
        modelMap.addAttribute("validationsErrors", errors);
        return "redirect:/" + page;
    }


    @RequestMapping(value = "/training", method = GET)
    public String goStartEducationMyFriend(ModelMap modelMap){
        if (modelMap.size() == 0)
            modelMap.addAttribute("result", RoundResult.NONE);
        List<Word> allWords =  wordService.getAll();
        List<Word> list =  new LinkedList<>();

        int length = allWords.size();
        Random rand = new Random();

        LinkedHashSet<Integer> setForCurrentTraining = new LinkedHashSet<>();
        for (; setForCurrentTraining.size() != 4; ){
            int val = rand.nextInt(length);
            if (setForCurrentTraining.contains(val))
                continue;
            list.add(allWords.get(val));
            setForCurrentTraining.add(val);
        }
        modelMap.addAttribute("words", list);
        int trueAnswer = rand.nextInt(4);
        modelMap.addAttribute("word", list.get(trueAnswer));
        modelMap.addAttribute("whichAnswerTrue", trueAnswer);
        return "word/training";
    }

    @RequestMapping(value = "/training/{whichAnswer}", method = POST)
    public String checkAnswerAndGoTrainingAgain(
            @PathVariable Long whichAnswer,
            @ModelAttribute("hack") @Validated ItIsHackButWhyNot hack,
            BindingResult bindingResult,
            ModelMap modelMap) {
        if (bindingResult.hasErrors()){
            return redirectIfWeHaveErrors(bindingResult, modelMap, "training");
        }
        boolean isTrueAnswer = whichAnswer == hack.getVal();
        wordService.incTrainingCount(hack.getId(), isTrueAnswer);
        RoundResult r = isTrueAnswer ? RoundResult.TRUE : RoundResult.FALSE;
        modelMap.addAttribute("result", r);

        //return "redirect:/training";
        return goStartEducationMyFriend(modelMap);
    }

}
