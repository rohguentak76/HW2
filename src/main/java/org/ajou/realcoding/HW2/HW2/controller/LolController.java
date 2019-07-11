package org.ajou.realcoding.HW2.HW2.controller;

import org.ajou.realcoding.HW2.HW2.domain.EncrypedInfo;
import org.ajou.realcoding.HW2.HW2.domain.SummonerInfo;
import org.ajou.realcoding.HW2.HW2.service.LolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class LolController {

    @Autowired
    LolService lolService;
    @GetMapping("/HW2/LolService/by-summoner-name/{summonerName}")
    public SummonerInfo getsummonerinfobyname(@PathVariable String summonerName){
        return lolService.getsummonerinfo(summonerName);
    }
    @GetMapping("/HW2/LolService/by-encrypedID/{encrypedID}")
    public List<EncrypedInfo> getencrypedinfobyencrypedId(@PathVariable String encrypedID){
        return lolService.getEncrypedinfo(encrypedID);
    }
    @GetMapping("/HW2/LolService/league-position/{summonerName}")
    public List<EncrypedInfo> getleaguepositionbyname(@PathVariable String summonerName){
        return getencrypedinfobyencrypedId(getsummonerinfobyname(summonerName).getId());
    }
}
