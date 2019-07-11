package org.ajou.realcoding.HW2.HW2.repository;

import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummonerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertleagueposition(List<EncrypedInfo> encrypedInfo){
        mongoTemplate.insert(encrypedInfo,EncrypedInfo.class);
    }

   /* public static SummonerInfo findsummonerinfobyname(String summonerName) {

    }*/
}
