package com.skoolco.tsa;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Mason Barnes mjackbarnes@gmail.com
 *
 * @version 1.0
 *
 * @since 1.0
 */

public class Post extends Sendable {

    public String body;
    public String head;
    public String poster;
    public ArrayList<String> stars;

    /**
     * This is the constructor method for a Post object which extends the Sendable abstract class
     *
     * <p>
     *     This object constructor takes in four arguments, h for the Title of the post, b for the body of the post,
     *     p for the original poster, and s for users who have starred the post.
     * </p>
     * @param h String, this is the parameter for the Title of the post
     * @param b String, this parameter holds the content of the post
     * @param p String, this parameter holds the ID of the original poster
     * @param s String[], this parameter holds a list of the IDs of users who have starred the post
     */
    public Post(String h, String b, String p, ArrayList<String> s){
        body = b;
        head = h;
        poster = p;
        stars = s;
    }

    /**
     * Converts data given in construction to a HashMap to make it postable to the Google Firebase Firestore Database.
     *
     * <p>
     *     This is a method used to simplify the creation of new objects in Google's Firetore Database
     *     which uses the HashMap object to interface with Java. The Sendable abstract class is where this is
     *     first declared. The method here converts the data given in the constructor method to a HashMap
     *     sendMap which can then be easily sent to the database for storage.
     * </p>
     *
     * @see Sendable
     *
     */
    @Override
    void makePostable() {
        HashMap<String, Object> out = new HashMap<>();
        out.put("Body", body);
        out.put("Title", head);
        out.put("poster", poster);
        out.put("stars", stars);
        this.sendMap = out;
    }


}
