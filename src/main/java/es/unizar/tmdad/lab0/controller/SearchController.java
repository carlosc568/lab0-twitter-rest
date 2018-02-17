package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.UncategorizedApiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.social.twitter.api.SearchResults;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SearchController {

    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/search")
    @ResponseBody
    public SearchResults search(@RequestParam("q") String q, Model m) {
        return twitter.search(q);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UncategorizedApiException.class)
    @ResponseBody  
    public SearchResults handleUncategorizedApiException(Model m) {
        return twitter.emptyAnswer();
    }
}