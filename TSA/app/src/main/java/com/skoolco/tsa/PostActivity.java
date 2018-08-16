package com.skoolco.tsa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * @author Mason Barnes mjackbarnes@gmail.com
 *
 * @version 1.0
 *
 * @since 1.0
 */

public class PostActivity extends AppCompatActivity {

    EditText body;
    EditText title;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage store = FirebaseStorage.getInstance();
    StorageReference storageRef = store.getReference();
    Uri[] images = new Uri[]{};
    private final int PICK_IMAGE = 100;

    /**
     * Method called on the creation of the view
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setTimestampsInSnapshotsEnabled(true).build();
        db.setFirestoreSettings(settings);

        // sets the current view to the main activity
//        setContentView(R.layout.activity_post);

        // makes a instance in java of the objects created in XML
        Button submit = findViewById(R.id.postSubmit);
        EditText title = findViewById(R.id.postTitle);
        EditText body = findViewById(R.id.postBody);

        // Set what happens when the button is pressed
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Post Added", Snackbar.LENGTH_LONG).show();
                newPost();
            }
        });

    }

    void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri imageUri = data.getData();
            images[images.length] = imageUri;
        }
    }

    void prepareUploads(){

    }
    /**
     * This method holds the code to gather the information to send a new post to be stored in the database
     *
     *<p>
     *     Scrapes text from EditText objects in the activity_post view and creates a Post object with the information
     *     held. This post is then sent to the database for storage.
     *</p>
     */
    public void newPost(){
//        post.put("Title", title.getText().toString());
//        post.put("Body", body.getText().toString());
//        post.put("poster", Data.user);
//        post.put("stars", new String[] {});

//        String header = title.getText().toString();
//        String main = body.getText().toString;
        String header = "title";
        String main = "body";
        Sendable post = new Post(header, main, "admin", new ArrayList<String>());
        post.setDb(db);
        post.makePostable();
        post.sendData("posts");
        Toast.makeText(this, "Posted", Toast.LENGTH_SHORT).show();
    }
}
