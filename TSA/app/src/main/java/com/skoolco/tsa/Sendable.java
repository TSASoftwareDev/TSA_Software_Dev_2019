package com.skoolco.tsa;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

/**
 * @author Mason Barnes mjackbarnes@gmail.com
 *
 * @version 1.0
 *
 * @since 1.0
 */

public abstract class Sendable {

    public FirebaseFirestore data;
    public HashMap<String, Object> sendMap;

    /**
     * Sets an instance of the database data for ease of use in Sendable objects
     *
     * @param db instance of the database
     */
    void setDb(FirebaseFirestore db){
        this.data = db;
    }

    /**
     * Sends the data held in the sendMap to the database in the collection identified in the param path
     *
     * @param path path to the collection the sendMap should be sent to
     *             Template ( "Collection/sub_collection" )
     */
    void sendData(String path){
        this.data.collection(path).add(sendMap);
    }

    /**
     * this method should be overridden to convert the data held in the object to a HashMap, then sent to sendMap
     */
    abstract void makePostable();
}
