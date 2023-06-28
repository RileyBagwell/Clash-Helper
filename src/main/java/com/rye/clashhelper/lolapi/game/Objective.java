package com.rye.clashhelper.lolapi.game;

import org.json.JSONObject;

public class Objective {
    private boolean first;
    private int kills;
    public Objective(JSONObject obj){
        first = obj.getBoolean("first");
        kills = obj.getInt("kills");
    }

    public boolean getFirst() { return first; }
    public int getKills() { return kills; }
}
