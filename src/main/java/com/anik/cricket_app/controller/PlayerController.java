package com.anik.cricket_app.controller;

import com.anik.cricket_app.model.PlayerRequest;
import com.anik.cricket_app.model.PlayerResponse;
import com.anik.cricket_app.service.PlayerService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@Log4j2
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(@Valid @RequestBody PlayerRequest playerRequest){
        log.info("Inside Player Controller Add Player");
        PlayerResponse playerResponse
                = playerService.addPlayer(playerRequest);
        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayers(){
        List<PlayerResponse> players
                = playerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable("id") Integer playerId){
        PlayerResponse playerResponse
                = playerService.getPlayerById(playerId);
        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable("id") Integer playerId){
        String message = playerService.deletePlayerById(playerId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerResponse>> getPlayersByRole(@RequestParam("role") String role){
        List<PlayerResponse> players
                = playerService.getPlayersByRole(role);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
