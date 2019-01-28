package com.stackroute.MuzixApp.services;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.EmptyFieldException;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.repository.TrackRepository;
import com.stackroute.MuzixApp.service.TrackServiceimpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackserviceTest {

    Track track;

    @Mock
    TrackRepository trackRepository;

    @InjectMocks
    TrackServiceimpl userService;
    List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackName("John");
        track.setTrackId(5);
        track.setTrackStatus("this is vinay");
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrackTest() throws TrackAlreadyExistsException, EmptyFieldException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = userService.saveTrack(track);
        Assert.assertEquals(track, savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).save(track);
    }

//    @Test(expected = TrackAlreadyExistsException.class)
//    public void saveUserTestFailure() throws TrackAlreadyExistsException,EmptyFieldException {
//        when(trackRepository.save((Track) any())).thenReturn(null);
//        Track savedTrack = userService.saveTrack(track);
//        System.out.println("savedUser" + savedTrack);
//        Assert.assertEquals(track, savedTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/




    @Test
    public void displayTrack(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = userService.displayTrack();
        Assert.assertEquals(list,userlist);
    }


}

