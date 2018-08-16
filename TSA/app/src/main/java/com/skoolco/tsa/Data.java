package com.skoolco.tsa;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * @author Mason Barnes mjackbarnes@gmail.com
 *
 * @version 1.0
 *
 * @since 1.0
 */

public class Data {
    public FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static String user = "admin";

    public Data(){

    }
}
