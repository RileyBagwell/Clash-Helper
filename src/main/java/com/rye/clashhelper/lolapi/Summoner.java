/*
 *  Stores information about a summoner w/ match history
 */

package com.rye.clashhelper.lolapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Summoner {
    private final int MATCHESTOSAVE = 30, MATCHSTART = 0;
    private Match[] matches;
    private String id, accountId, puuid, name;
    private int profileIconId, summonerLevel;
    private long revisionDate;

    /*
     *  Create a Summoner object given a region, str, and isName. str is a puuid or a summoner name. isName is a
     *  boolean that is true if str is a name, and false if it's a puuid. The correct endpoint is called based on
     *  this boolean.
     */
    public Summoner(String _region, String str, boolean isName) throws IOException {
        String urlStr;
        if(isName)
            urlStr = "https://" + _region + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + str + "?";
        else
            urlStr = "https://" + _region + ".api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + str + "?";
        APIHandler handler = new APIHandler(urlStr);
        JSONObject jsonObject = new JSONObject(handler.getResponse().toString());
        id = jsonObject.getString("id");
        accountId = jsonObject.getString("accountId");
        puuid = jsonObject.getString("puuid");
        name = jsonObject.getString("name");
        profileIconId = jsonObject.getInt("profileIconId");
        revisionDate = jsonObject.getNumber("revisionDate").longValue();
        summonerLevel = jsonObject.getInt("summonerLevel");
        // Request match history
        urlStr = "https://" + "americas" + ".api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=" + MATCHSTART + "&count=" + MATCHESTOSAVE + "&";
        handler = new APIHandler(urlStr);
        JSONArray matchIds = new JSONArray(handler.getResponse().toString());
        // Save them to match array
        for(int i = 0; i < MATCHESTOSAVE; i++){
            matches[i] = new Match(_region, matchIds.getString(i));
        }
    }



    /*
     *  Print all information about the summoner
     */
    public String toString(){
        return "id: " + id + "\naccountId: " + accountId + "\npuuid: " + puuid +
                "\nname: " + name + "\nprofileIconId: " + profileIconId +
                "\nrevisionDate: " + revisionDate + "\nsummonerLevel: " + summonerLevel;
    }



    /*
     *  Accessor methods
     */
    public String getId() { return id; }
    public String getAccountId() { return accountId; }
    public String getPuuid() { return puuid; }
    public String getName() { return name; }
    public int getProfileIconId() { return profileIconId; }
    public long getRevisionDate() { return revisionDate; }
    public int getSummonerLevel() { return summonerLevel; }
    public Match[] getMatches() { return matches; }
    public Match getMatch(int index) { return matches[index]; }
}