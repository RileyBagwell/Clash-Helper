/*
 *  Handles API requests
 *  To use, create an APIHandler object by passing a region and an endpoint.
 *  Then call request(). Response can be accessed with getResponse() and response code
 *  with getResponseCode().
 */

package com.rye.clashhelper.lolapi;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIHandler {
    private final Dotenv config;
    private URL url;
    HttpURLConnection con;
    private String apiKey;
    private String response;
    private int responseCode;



    /*
     *  Create an APIHandler object given a String containing the URL
     *  to request from, minus the "api_key=xxxxxxx" suffix.
     */
    public APIHandler(String _url) throws IOException {
        config = Dotenv.configure().load();
        apiKey = config.get("APIKEY");
        url = new URL(_url + "api_key=" + apiKey);
        con = (HttpURLConnection) url.openConnection(); // Create an HTTP connection object
        con.setRequestMethod("GET"); // Set the request method
        con.setRequestProperty("X-Riot-Token", apiKey); // Add API to the request header
        request();
    }



    /*
     *  Sends a request to the object's endpoint. Returns the response and saves it
     *  and the response code.
     */
    public String request() throws IOException {
        responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer responseBuff = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            responseBuff.append(inputLine);
        in.close();
        response = responseBuff.toString();
        return response;
    }



    /*
     *  Accessor methods
     */
    public String getResponse() { return response; }
    public int getResponseCode() { return responseCode; }
    public String getUrl() { return url.toString(); } // Return the URL as a string
}