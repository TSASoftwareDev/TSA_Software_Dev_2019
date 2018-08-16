package com.skoolco.tsa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;

/**
 * @author Mason Barnes mjackbarnes@gmail.com
 *
 * @version 1.0
 *
 * @since 1.0
 *
 * <p>
 *     The fucking main screen
 * </p>
 */

public class NotesActivity extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setTimestampsInSnapshotsEnabled(true).build();
        db.setFirestoreSettings(settings);
        list = findViewById(R.id.notesList);

        populateListView();
    }

    private void populateListView() {
//        CollectionReference posts = db.collection("posts");
//        QuerySnapshot qs = posts.get().getResult();
//        Object[] array = qs.getDocuments().toArray();
    }
}
