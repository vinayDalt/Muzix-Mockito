package com.stackroute.MuzixApp.controller;


import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.EmptyFieldException;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;
import com.stackroute.MuzixApp.service.TrackService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1")
@Api(value = "MuzixTrack",description = "Music Track List")
public class Trackcontroller {

    private TrackService trackService;

    @Autowired
    public Trackcontroller(TrackService trackService){

        this.trackService=trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException, EmptyFieldException {

        ResponseEntity responseEntity;
        try {

            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("created", HttpStatus.CREATED);
        }

        catch (EmptyFieldException e) {
            responseEntity= new ResponseEntity<String>(e.message,HttpStatus.BAD_REQUEST);
        }

        catch (TrackAlreadyExistsException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> displayTrack(){


        return new ResponseEntity<List<Track>>(trackService.displayTrack(),HttpStatus.OK);
    }

@PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException,EmptyFieldException {

    ResponseEntity responseEntity;

    try {

        trackService.updateTrack(track);
        responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
    }

    catch (EmptyFieldException e) {
        responseEntity= new ResponseEntity<>(e.message,HttpStatus.BAD_REQUEST);
    }

    catch (TrackNotFoundException e) {
        responseEntity= new ResponseEntity<>(e.message,HttpStatus.NOT_FOUND);
    }

   return responseEntity;

   }

@DeleteMapping("track/{trackId}")
public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackId) {

        ResponseEntity responseEntity;

            trackService.deleteTrack(trackId);
            responseEntity=new ResponseEntity<String>("deleted",HttpStatus.OK);


        return responseEntity;

}


}
