package com.rye.clashhelper.lolapi.clash;

import com.rye.clashhelper.lolapi.APIHandler;
import com.rye.clashhelper.lolapi.Summoner;
import org.json.JSONObject;

import java.io.IOException;

public class Team {
    private Summoner[] summoners;
    private String id, name, captain, abbreviation;
    private int tournamentId, iconId, tier;

    public Team(String _region, String _teamId) throws IOException {
        id = _teamId;
        String urlStr = "https://" + _region + ".api.riotgames.com/lol/clash/v1/teams/" + id + "?";
        APIHandler handler = new APIHandler(urlStr);
        JSONObject jsonObject = new JSONObject(handler.getResponse().toString());
        // Assign fields
        name = jsonObject.getString("name");
        captain = jsonObject.getString("captain");
        abbreviation = jsonObject.getString("abbreviation");
        tournamentId = jsonObject.getInt("tournamentId");
        iconId = jsonObject.getInt("iconId");
        tier = jsonObject.getInt("tier");
        for(int i = 0; i < summoners.length; i++) {
            String tempSummId = jsonObject.getJSONArray("players").getJSONObject(i).getString("summonerId");
            summoners[i] = new Summoner(_region, tempSummId, false);
        }
    }



    /*
     *  Accessor methods
     */
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCaptain() { return captain; }
    public String getAbbreviation() { return abbreviation; }
    public int getTournamentId() { return tournamentId; }
    public int getIconId() { return iconId; }
    public int getTier() { return tier; }
    public Summoner[] getSummoners() { return summoners; }
    public Summoner getSummoner(int index) { return summoners[index]; }
}
