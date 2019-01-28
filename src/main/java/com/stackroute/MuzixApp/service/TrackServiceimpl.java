package com.stackroute.MuzixApp.service;


import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.EmptyFieldException;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;
import com.stackroute.MuzixApp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceimpl implements TrackService {


    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceimpl(TrackRepository trackRepository)
    {

        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException, EmptyFieldException {
        Track saveTrack=trackRepository.save(track);
        return saveTrack;

    }

@Override
    public List<Track> displayTrack(){

        return trackRepository.findAll();

     }

     @Override
    public Track updateTrack(Track track) throws TrackNotFoundException,EmptyFieldException{

        track.setTrackName(track.getTrackName());
        track.setTrackStatus(track.getTrackStatus());
       // TrackService.saveTrack(track);
        return trackRepository.save(track);

     }



     @Override
    public boolean deleteTrack(int trackId)  {

        if(trackRepository.existsById(trackId)){

            trackRepository.deleteById(trackId);
            return true;
        }
        return false;
     }
}
