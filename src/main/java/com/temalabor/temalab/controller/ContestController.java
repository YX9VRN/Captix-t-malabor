package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.Contest;
import com.temalabor.temalab.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contests")
@CrossOrigin(origins = "http://localhost:4200")

public class ContestController {

    @Autowired
    private ContestRepository contestRepository;

    @PostMapping()
    public Contest newContest(@RequestBody Contest contest){
        return contestRepository.save(contest);
    }
    @GetMapping()
    public List<Contest> getContests(){
        return contestRepository.findAll();
    }
}
