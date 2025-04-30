package com.anik.cricket_app.service;

import com.anik.cricket_app.model.PlayerRequest;
import com.anik.cricket_app.model.PlayerResponse;

import java.util.List;

public interface PlayerService {
    PlayerResponse addPlayer(PlayerRequest playerRequest);
    List<PlayerResponse> getPlayers();
    PlayerResponse getPlayerById(Integer playerId);
    String deletePlayerById(Integer playerId);
    List<PlayerResponse> getPlayersByRole(String role);
}
