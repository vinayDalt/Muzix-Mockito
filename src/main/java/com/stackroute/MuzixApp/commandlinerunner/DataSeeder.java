package com.stackroute.MuzixApp.commandlinerunner;


import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {


    private TrackService trackService;



    @Autowired
    public DataSeeder(TrackService trackService){

        this.trackService=trackService;

    }

   // Track track=new Track();

    @Override
    public void run(String... args) throws Exception {

        Track track1=Track.builder().trackName("vinuuuuu").trackStatus("fghhh").build();
        trackService.saveTrack(track1);

        Track track2=Track.builder().trackName("vinay").trackStatus("abcd").build();
        trackService.saveTrack(track2);
       // trackService.saveTrack(new Track());

    }
}
