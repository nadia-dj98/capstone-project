package com.example.voluntech_jobboard.Controllers;

import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/charities")
public class CharityController {

    @Autowired
    CharityService charityService;


    //create charity
    @PostMapping
    public ResponseEntity<Charity> createNewCharity(@RequestBody Charity charity) {
        charityService.addCharity(charity);
        return new ResponseEntity<>(charity, HttpStatus.CREATED);
    }

    //get all charities
    @GetMapping
    public  ResponseEntity<List<Charity>> getAllCharities(){
        List<Charity> allCharities = charityService.getAllCharities();
        return new ResponseEntity<>(allCharities, HttpStatus.OK);
    }

    //delete charity -> need to change method to id

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteCharity(@PathVariable long id) {
        charityService.deleteCharity(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }




}
