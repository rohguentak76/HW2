package org.ajou.realcoding.HW2.HW2.api;

import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class DeveloperriotgamesApiClient {
    private final String appid = "RGAPI-527bedc3-cb3a-4467-8d90-6a8296082961";
    private final String summnerURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";
    private final String encrypedURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";
    @Autowired
    private RestTemplate restTemplate;

    public SummonerInfo requestSummonerInfo(String summonerName){
        return restTemplate.exchange(summnerURL, HttpMethod.GET,null,SummonerInfo.class , summonerName,appid).getBody();
    }
    public List<EncrypedInfo> requestEncryedInfo(String encrypedId){
        return restTemplate.exchange(encrypedURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<EncrypedInfo>>() {
        }, encrypedId, appid).getBody();

    }
}
