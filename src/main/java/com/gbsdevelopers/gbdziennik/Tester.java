package com.gbsdevelopers.gbdziennik;

import com.gbsdevelopers.gbssocket.GbsClient;
import com.gbsdevelopers.gbssocket.GbsMessage;

import java.io.IOException;
import java.util.Vector;

/**
 * Simple tester class
 */
public class Tester {

    /**
     * Main class
     * @param args program arguments
     */
    public static void main(String[] args) {
        GbsClient client = new GbsClient(25565, "localhost");

        Vector<String> dbArgs = new Vector<>();

        dbArgs.add("localhost");
        dbArgs.add("3306");
        dbArgs.add("gbdziennik");
        dbArgs.add("gbdziennik");
        dbArgs.add("gbdziennik");

        try {
            client.executeRequest(new GbsMessage("_configureDB", dbArgs));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GbsMessage request = new GbsMessage();

        request.header = "_listAccounts";

        request.arguments = new Vector<>();
        

        GbsMessage reply = new GbsMessage();

        try {
            reply = client.executeRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(reply.header);

        for (String replyLine : reply.arguments) {
            System.out.println(replyLine);
        }

    }
}
