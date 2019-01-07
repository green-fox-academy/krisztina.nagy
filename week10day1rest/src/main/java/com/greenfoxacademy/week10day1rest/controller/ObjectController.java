package com.greenfoxacademy.week10day1rest.controller;

import com.greenfoxacademy.week10day1rest.model.*;
import com.greenfoxacademy.week10day1rest.repository.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class ObjectController {

    private LogServiceImpl logSvc;

    @Autowired
    public ObjectController(LogServiceImpl logSvc){
        this.logSvc = logSvc;
    }

    @GetMapping("/doubling")
    public Object doubleTheInput(@RequestParam(value = "input", required=false) Integer input){
        logSvc.addLog(new Log("/doubling", "input="+input));
        if (input != null) {
            return new Doubler(input);
        }
        else {
            return new NoParamError();
        }
    }

    @GetMapping("/greeter")
    public Object awesomeGreeting (@RequestParam MultiValueMap<String, String> params){
        String name = params.toSingleValueMap().get("name");
        String title = params.toSingleValueMap().get("title");

        logSvc.addLog(new Log("/greeter", "input="+name+", "+title));

        if (name!=null && title!=null) {
            return new AwesomeGreeting(name, title);
        }
        else if(name==null && title!=null) {
            return new NoParamError("name");
        }
        else if(name!=null && title==null) {
            return new NoParamError("title");
        }
        else{
            return new NoParamError();
        }

    }

    @GetMapping("/appenda/{appendable}")
    public Object appendA (@PathVariable String appendable, HttpServletResponse res) throws IOException {
        logSvc.addLog(new Log("/appenda", "input="+appendable));
        if (appendable!=null) {
            return new AppendA(appendable);
        }
        else {
            res.sendError(404);
            return null;
        }
    }

    @PostMapping(value = "/dountil/{action}")
    public Object iterateAction (@PathVariable String action, @RequestBody HashMap<String, Integer> inputMap){

        Integer myNumber = inputMap.get("until");
        logSvc.addLog(new Log("/dountil/"+action, "input="+myNumber));

        switch (action) {
            case "sum": return new SumUntil(myNumber);
            case "factor": return new FactorUntil(myNumber);
            default: return new NoParamError("number");
            }
    }

    @PostMapping("/arrays")
    public Object arrayActions(@RequestBody ArrayInput aInput){
        logSvc.addLog(new Log("/arrays", "input=" + aInput.getWhat() + ", " + aInput.getNumbers()));
        if (aInput.getNumbers()!=null && aInput.getWhat()!=null ) {
            switch (aInput.getWhat()) {
                case "sum":
                    return new ArraySummer(aInput.getNumbers());
                case "multiply":
                    return new ArrayMultiplier(aInput.getNumbers());
                case "double":
                    return new ArrayDoubler(aInput.getNumbers());
                default:
                    return new NoParamError("number");
            }
        }
        else if (aInput.getNumbers()!=null){
            return new ArrayError("Please provide what to do with the numbers!");
        }
        else return new ArrayError("Please provide the numbers!");
    }

    @GetMapping("/log")
    public List<Object> getLog (){
        List<Log> entries = logSvc.getAllEntries();
        return Arrays.asList(entries, logSvc.countEntries());
    }

    @PostMapping("/sith")
    public Object sithReverser(@RequestBody SithInput sithInput){
        return new SithText(sithInput.getText());
    }


}
