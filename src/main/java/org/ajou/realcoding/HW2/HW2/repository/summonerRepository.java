package org.ajou.realcoding.HW2.HW2.repository;

import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummonerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateleagueposition(String summonername, EncrypedInfo encrypedInfos){
        Query query = Query.query(Criteria.where("summonerName").is(summonername));
        Update update = new Update();

        update.set("wins",encrypedInfos.getWins());
        update.set("losses",encrypedInfos.getLosses());
        update.set("rank",encrypedInfos.getRank());
        update.set("tier",encrypedInfos.getTier());
        update.set("leaguePoints",encrypedInfos.getLeaguePoints());
        mongoTemplate.updateFirst(query,update,EncrypedInfo.class);
    }
    public void insertleagueposition(List<EncrypedInfo> encrypedInfo){
        mongoTemplate.insert(encrypedInfo,EncrypedInfo.class);
    }
   public boolean findoneifexist(List<EncrypedInfo> encrypedInfos){
       Query query = Query.query(Criteria.where("summonerName").is(encrypedInfos.get(0).getSummonerName()));
       return mongoTemplate.exists(query, EncrypedInfo.class);
   }
   /* public static SummonerInfo findsummonerinfobyname(String summonerName) {

    }*/
}
