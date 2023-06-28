/*
 *  Stores information about a match
 *  Game duration and game type is available, as well as the participant IDs and team IDs
 */

package com.rye.clashhelper.lolapi;

import com.rye.clashhelper.lolapi.game.GameTeam;
import com.rye.clashhelper.lolapi.game.Participant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Match {
    private String matchId, dataVersion, gameMode, gameName, gameType, gameVersion;
    private String[] participantsIds; // List of participant puuids
    private Participant[] participants;
    private long gameDuration, gameId;
    private int queueId, mapId;
    private GameTeam[] teams;

    public Match(String _region, String _matchId) throws IOException {
        matchId = _matchId;
        String urlStr = "https://" + "americas" + ".api.riotgames.com/lol/match/v5/matches/" + matchId + "?";
        APIHandler handler = new APIHandler(urlStr);
        JSONObject jsonObject = new JSONObject(handler.getResponse().toString());
        JSONObject info = new JSONObject(jsonObject.getJSONObject("info"));

        dataVersion = jsonObject.getString("dataVersion");
        matchId = jsonObject.getString("matchId");
        for(int i = 0; i < 10; i++)
            participantsIds[i] = jsonObject.getJSONArray("participants").getString(i);
        gameDuration = info.getLong("gameDuration");
        gameId = info.getLong("gameId");
        gameMode = info.getString("gameMode");
        gameName = info.getString("gameName");
        gameType = info.getString("gameType");
        gameVersion = info.getString("gameVersion");
        mapId = info.getInt("mapId");
        queueId = info.getInt("queueId");
        JSONArray jsonTeams = new JSONArray(info.getJSONArray("teams"));
        for(int i = 0; i < 2; i++)
            teams[i] = new GameTeam(jsonTeams.getJSONObject(i));
        JSONArray jsonParticipants = new JSONArray(info.getJSONArray("participants"));
        for(int i = 0; i < 10; i++)
            participants[i] = new Participant(jsonParticipants.getJSONObject(i));
    }

    /*
     *  Accessor methods
     */
    public String getParticipantId(int index) { return participantsIds[index]; }
    public Participant getParticipant(int index) { return participants[index]; }
    public long getGameDuration() { return gameDuration; }
    public int getQueueId() { return queueId; }
}
