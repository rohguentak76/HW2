package org.ajou.realcoding.HW2.HW2.repository;

import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class summonerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


   /* public static SummonerInfo findsummonerinfobyname(String summonerName) {

    }*/
}
