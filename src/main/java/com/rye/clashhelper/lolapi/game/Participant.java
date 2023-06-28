/*
 *  Hold all match information for a participant
 *
 *  Relevant fields are declared, but needs to be initialized in constructor and
 *  getter methods written
 */

package com.rye.clashhelper.lolapi.game;

import org.json.JSONObject;

public class Participant {
    private int champLevel, damageDealtToObjectives, damageDealtToTurrets, damageDealtToBuildings, damageSelfMitigated, detectorWardsPlaced, participantId, profileIcon,
        kills, deaths, assists, doubleKills, tripleKills, quadraKills, pentaKills, killingSprees, largestKillingSpree, largestMultiKill,
        magicDamageDealt, magicDamageDealtToChampions, physicalDamageDealt, physicalDamageDealtToChampions, totalDamageDealt, totalDamageDealtToChampions, trueDamageDealt, trueDamageDealtToChampions,
        totalDamageShieldedOnTeammates, totalHeal, totalHealsOnTeammates, totalMinionsKilled, visionScore, wardsKilled, wardsPlaced,
        goldEarned, inhibitorKills, inhibitorTakedowns, inhibitorsLost, objectivesStolen, objectivesStolenAssists, sightWardsBoughtInGame, turretKills, turretTakedowns,
        item0, item1, item2, item3, item4, item5, item6, summoner1Id, summoner2Id, timeCCingOthers, totalTimeCCDealt, largestCriticalStrike;
    private String puuid, championName, teamPosition, lane, role;
    private boolean firstBloodKill, firstBloodAssist, firstTowerKill, gameEndedInEarlySurrender, gameEndedInSurrender, win;

    public Participant(JSONObject participant) {
        champLevel = participant.getInt("champLevel");
        damageDealtToObjectives = participant.getInt("damageDealtToObjectives");
        damageDealtToTurrets = participant.getInt("damageDealtToTurrets");
        damageDealtToBuildings = participant.getInt("damageDealtToBuildings");
        damageSelfMitigated = participant.getInt("damageSelfMitigated");
        detectorWardsPlaced = participant.getInt("detectorWardsPlaced");
        participantId = participant.getInt("participantId");
        profileIcon = participant.getInt("profileIcon");
        kills = participant.getInt("kills");
        deaths = participant.getInt("deaths");
        assists = participant.getInt("assists");
        doubleKills = participant.getInt("doubleKills");
        tripleKills = participant.getInt("tripleKills");
        quadraKills = participant.getInt("quadraKills");
        pentaKills = participant.getInt("pentaKills");
        killingSprees = participant.getInt("killingSprees");
        largestKillingSpree = participant.getInt("largestKillingSpree");
        largestMultiKill = participant.getInt("largestMultiKills");
        magicDamageDealt = participant.getInt("magicDamageDealt");
        magicDamageDealtToChampions = participant.getInt("magicDamageDealtToChampions");
        physicalDamageDealt = participant.getInt("physicalDamageDealt");
        physicalDamageDealtToChampions = participant.getInt("physicalDamageDealtToChampions");
    }

    /*
     * Accessor methods
     */
    public int getKills() { return kills; }
    public int getDeaths() { return deaths; }
    public int getAssists() { return assists; }
}
