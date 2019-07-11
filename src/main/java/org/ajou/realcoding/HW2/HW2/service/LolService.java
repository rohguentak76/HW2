package org.ajou.realcoding.HW2.HW2.service;

import org.ajou.realcoding.HW2.HW2.api.DeveloperriotgamesApiClient;
import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.ajou.realcoding.HW2.HW2.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LolService {

    @Autowired
    DeveloperriotgamesApiClient developerriotgamesApiClient;
    @Autowired
    private SummonerRepository summonerRepository;
    public SummonerInfo getsummonerinfo(String summonerName) {
        return developerriotgamesApiClient.requestSummonerInfo(summonerName);
    }
    public List<EncrypedInfo> getEncrypedinfo(String summonerName){
        List<EncrypedInfo> encrypedInfos = developerriotgamesApiClient.requestEncryedInfo(developerriotgamesApiClient.requestSummonerInfo(summonerName).getId());
        if(summonerRepository.findoneifexist(encrypedInfos)){
            summonerRepository.updateleagueposition(summonerName,encrypedInfos.get(0));
            System.out.println("db is update");
        }
        else {
            summonerRepository.insertleagueposition(encrypedInfos);
            System.out.println("inserting data");
        }
        return encrypedInfos;
    }

}
