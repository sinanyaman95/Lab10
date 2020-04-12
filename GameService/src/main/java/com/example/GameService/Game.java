/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.GameService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Sinan
 */
@Data
@Entity
public class Game {
    private String name;
    private long users;
    
    @GeneratedValue
    @Id
    private long id;
}
