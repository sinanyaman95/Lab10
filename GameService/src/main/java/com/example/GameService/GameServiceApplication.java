package com.example.GameService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GameServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameServiceApplication.class, args);
	}

}

@Component
class ItemInitializer implements CommandLineRunner {
    
    private final IGameRepository repo;
    
    ItemInitializer(IGameRepository _repo){
        this.repo = _repo;
    }
    @Override
    public void run(String... args) throws Exception {
        Game game1 = new Game();
        game1.setName("Counter Strike : Global Offensive");
        game1.setUsers(20000000);
        repo.save(game1);
        
        Game game2 = new Game();
        game2.setName("League of Legends");
        game2.setUsers(80000000);
        repo.save(game2);
        
        Game game3 = new Game();
        game3.setName("Valorant");
        game3.setUsers(1600000);
        repo.save(game3);
        
        Game game4 = new Game();
        game4.setName("Call of Duty: Warzone");
        game4.setUsers(6000000);
        repo.save(game4);
        
        Game game5 = new Game();
        game5.setName("World of Warcraft");
        game5.setUsers(32000000);
        repo.save(game5);
        
        repo.findAll().forEach(System.out::println);
    }
    
}
