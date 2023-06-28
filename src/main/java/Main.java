/*
 *  Author: Riley Bagwell
 *  Last Edit: 5/1/2023
 *  Practice using API requests from the Riot API
 */

import com.rye.clashhelper.lolapi.Summoner;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        //Summoner summ = new Summoner("na1", "Blockerw1z", true);
        //System.out.println(summ.toString());
        //Match match = new Match("americas", "NA1_4644451922");
        //System.out.println(match.getParticipant(0));
        Summoner summ = new Summoner("na1", "Blockerw1z", true);
        System.out.println(summ.getMatch(1).getParticipant(1).getKills());
    }
}
