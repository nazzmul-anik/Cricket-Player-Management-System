package com.anik.cricket_app.service;

import com.anik.cricket_app.entity.PlayerEntity;
import com.anik.cricket_app.exception.CricketAppServiceRuntimeException;
import com.anik.cricket_app.model.PlayerRequest;
import com.anik.cricket_app.model.PlayerResponse;
import com.anik.cricket_app.repository.PlayerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        log.info("Inside PlayerService Add Player Method Begins");

        PlayerEntity player
                = new PlayerEntity();
        PlayerResponse playerResponse
                = new PlayerResponse();
        BeanUtils.copyProperties(playerRequest, player);
        playerRepository.save(player);
        BeanUtils.copyProperties(player, playerResponse);

        log.info("Inside PlayerService Add Player Method Ends");
        return playerResponse;
    }

    @Override
    public List<PlayerResponse> getPlayers() {
        log.info("Inside get All Players Method Begins");
        List<PlayerEntity> players
                = playerRepository.findAll();
        List<PlayerResponse> playerResponseList
                = players
                .stream()
                .map(playerEntity -> {
                    PlayerResponse response
                            = new PlayerResponse();
                    BeanUtils.copyProperties(playerEntity, response);
                    return response;
                })
                .collect(Collectors.toList());

        log.info("Inside get All Players Method Ends");
        return playerResponseList;
    }

    @Override
    public PlayerResponse getPlayerById(Integer playerId) {
        log.info("Inside Get Player By Id Method Begins");
        PlayerEntity player
                = playerRepository.findById(playerId)
                .orElseThrow(
                        () -> new CricketAppServiceRuntimeException("Player not found with given id : "+playerId,
                                "PLAYER_NOT_FOUND")
                );
        PlayerResponse playerResponse
                = new PlayerResponse();
        BeanUtils.copyProperties(player, playerResponse);
        log.info("Inside Get Player By Id Method Ends");
        return playerResponse;
    }

    @Override
    public String deletePlayerById(Integer playerId) {
        log.info("Inside Delete Player By Id Method Begins");
        playerRepository.deleteById(playerId);
        return "Player with the Id: "+playerId+" deleted Successfully!";
    }

    @Override
    public List<PlayerResponse> getPlayersByRole(String role) {
        log.info("Inside of Get Players By Role Method Begins");
        List<PlayerEntity> players
                = playerRepository.findAllByRole(role);
        List<PlayerResponse> playerResponses
                = players
                .stream()
                .map(playerEntity -> {
                    PlayerResponse response
                            = new PlayerResponse();
                    BeanUtils.copyProperties(playerEntity, response);
                    return response;
                })
                .collect(Collectors.toList());

        return playerResponses;
    }
}
