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
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sinan
 */
@FeignClient("movie-service")
public interface IMovieClient {
    
    @RequestMapping("/movies")
    CollectionModel<Movie> readMovies();
    
}
