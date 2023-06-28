package com.rye.clashhelper.lolapi.game;

public class Ban {
    private int championId, pickTurn;

    public Ban(int _championId, int _pickTurn){
        championId = _championId;
        pickTurn = _pickTurn;
    }

    public int getChampionId() { return championId; }
    public int getPickTurn() { return pickTurn; }
}
