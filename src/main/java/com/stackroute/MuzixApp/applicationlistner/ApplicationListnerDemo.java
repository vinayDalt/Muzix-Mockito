package com.stackroute.MuzixApp.applicationlistner;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.repository.TrackRepository;
import com.stackroute.MuzixApp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListnerDemo implements ApplicationListener<ContextRefreshedEvent>
{
    private TrackRepository trackRepository;



    @Autowired
    public ApplicationListnerDemo(TrackRepository trackRepository){

        this.trackRepository=trackRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Track track1=Track.builder().trackName("vinuuuuu").trackStatus("fghhh").build();
        trackRepository.save(track1);

        Track track2=Track.builder().trackName("hello").trackStatus("abcd").build();
        trackRepository.save(track2);
    }
}
