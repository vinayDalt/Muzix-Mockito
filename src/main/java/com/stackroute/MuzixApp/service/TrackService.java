package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.EmptyFieldException;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackService  {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException,EmptyFieldException;
    public List<Track> displayTrack();

    public Track updateTrack(Track track) throws TrackNotFoundException, EmptyFieldException;


    public boolean deleteTrack(int trackId) ;

}
