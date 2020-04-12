/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EdgeService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sinan
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class GameRestController {
    
    @Autowired
    private IGameClient gameClient;
    
    @GetMapping("/games")
    @HystrixCommand(fallbackMethod = "fallbackGames")
    public Collection<Game> getGames(){
        return gameClient.readGames().getContent().stream().collect(Collectors.toList());
    }
    
    public Collection<Game> fallbackGames(){
        List<Game> gameList = new ArrayList<>();
        Game game1 = new Game();
        game1.setName("Counter Strike : Global Offensive");
        game1.setUsers(20000000);
        
        Game game2 = new Game();
        game2.setName("League of Legends");
        game2.setUsers(80000000);
       
        gameList.add(game1);
        gameList.add(game2);
        return gameList;
        
    }
}
