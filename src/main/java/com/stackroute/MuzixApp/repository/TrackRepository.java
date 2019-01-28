package com.stackroute.MuzixApp.repository;

//import com.mongodb.Mongo;
import com.stackroute.MuzixApp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {




}
