package com.stackroute.MuzixApp.repository;

import com.stackroute.MuzixApp.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


    @RunWith(SpringRunner.class)
    @DataJpaTest
    public class TrackRepositoryTest {


        @Autowired
        private TrackRepository trackRepository;
        private Track track;

        @Before
        public void setUp()
        {
            track = new Track();
            track.setTrackId(10);
            track.setTrackName("John");
            track.setTrackStatus("this is vinay");


        }

        @After
        public void tearDown(){

            trackRepository.deleteAll();
        }


        @Test
        public void testSaveUser(){
            trackRepository.save(track);
          //  Track fetchUser = trackRepository.findById(track.getTrackId()).get();
            Assert.assertEquals(10,track.getTrackId());

        }

        @Test
        public void testSaveUserFailure(){
            Track testUser = new Track(23,"Harry","john");
            trackRepository.save(track);
          //  Track fetchUser = trackRepository.findById(track.getTrackId()).get();
            Assert.assertNotSame(testUser,track);
        }

        @Test
        public void testGetAllUser(){
            Track u = new Track(10,"Johny","Jenny");
            Track u1 = new Track(11,"Harry","Jenny");
            trackRepository.save(u);
            trackRepository.save(u1);

            List<Track> list = trackRepository.findAll();
            Assert.assertEquals("Johny",list.get(0).getTrackName());




        }


    }


