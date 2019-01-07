package com.greenfoxacademy.week10frontend.controller;

import com.greenfoxacademy.week10frontend.model.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class ObjectController {

    @GetMapping("/doubling")
    public Object doubleTheInput(@RequestParam(value = "input", required=false) Integer input){
        if (input != null) {
            return new Doubler(input);
        }
        else {
            return new noParamError();
        }
    }

    @GetMapping("/greeter")
    public Object awesomeGreeting (@RequestParam MultiValueMap<String, String> params){
        String name = params.toSingleValueMap().get("name");
        String title = params.toSingleValueMap().get("title");

        if (name!=null && title!=null) {
            return new AwesomeGreeting(name, title);
        }
        else if(name==null && title!=null) {
            return new noParamError("name");
        }
        else if(name!=null && title==null) {
            return new noParamError("title");
        }
        else{
            return new noParamError();
        }

    }

    @GetMapping("/appenda/{appendable}")
    public Object appendA (@PathVariable String appendable, HttpServletResponse res) throws IOException {
        if (appendable!=null) {
            return new AppendA(appendable);
        }
        else {
            res.sendError(404);
            return null;
        }
    }

    @PostMapping("/dountil/{action}")
    public Object iterateAction (@PathVariable String action, @RequestBody HashMap<String, Integer> inputMap){

        Integer myNumber = inputMap.get("until");

        switch (action) {
            case "sum": return new SumUntil(myNumber);
            case "factor": return new FactorUntil(myNumber);
            default: return new noParamError("number");
            }
        }


}
