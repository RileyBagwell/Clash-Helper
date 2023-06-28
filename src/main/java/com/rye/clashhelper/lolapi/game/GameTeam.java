package com.rye.clashhelper.lolapi.game;

import org.json.JSONObject;

public class GameTeam {
    private Ban[] bans;
    private Objectives objectives;
    private boolean win;
    private int teamId;

    public GameTeam(JSONObject team) {
        win = team.getBoolean("win");
        teamId = team.getInt("teamId");
        objectives = new Objectives(team.getJSONObject("objectives"));
    }

    /*
     *  Accessor methods
     */
    public boolean getWin() { return win; }
    public int getTeamId() { return teamId; }
    public Ban[] getBans() { return bans; }
    public Ban getBan(int index) { return bans[index]; }
    public Objectives getObjectives() { return objectives; }
}
