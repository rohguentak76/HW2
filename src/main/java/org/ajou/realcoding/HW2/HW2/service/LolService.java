package org.ajou.realcoding.HW2.HW2.service;

import org.ajou.realcoding.HW2.HW2.api.DeveloperriotgamesApiClient;
import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.ajou.realcoding.HW2.HW2.repository.summonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LolService {

    @Autowired
    DeveloperriotgamesApiClient developerriotgamesApiClient;
    public SummonerInfo getsummonerinfo(String summonerName) {
        return developerriotgamesApiClient.requestSummonerInfo(summonerName);
    }
    public List<EncrypedInfo> getEncrypedinfo(String encrypedId){
        return developerriotgamesApiClient.requestEncryedInfo(encrypedId);
    }
}
