package com.rye.clashhelper.lolapi.game;

import org.json.JSONObject;

public class Objectives {
    Objective baron, champion, dragon, inhibitor, riftHerald, tower;
    public Objectives(JSONObject objs){
        baron = new Objective(objs.getJSONObject("baron"));
        champion = new Objective(objs.getJSONObject("champion"));
        dragon = new Objective(objs.getJSONObject("dragon"));
        inhibitor = new Objective(objs.getJSONObject("inhibitor"));
        riftHerald = new Objective(objs.getJSONObject("riftHerald"));
        tower = new Objective(objs.getJSONObject("tower"));
    }

    public Objective getBaron() { return baron; }
    public Objective getChampion() { return champion; }
    public Objective getDragon() { return dragon; }
    public Objective getInhibitor() { return inhibitor; }
    public Objective getRiftHerald() { return riftHerald; }
    public Objective getTower() { return tower; }
}
