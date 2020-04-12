/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EdgeService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sinan
 */
@FeignClient("game-service")
public interface IGameClient {
    @RequestMapping("/games")
    CollectionModel<Game> readGames();
}
