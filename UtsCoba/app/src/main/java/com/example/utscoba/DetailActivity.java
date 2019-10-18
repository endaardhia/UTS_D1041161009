package com.example.utscoba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/***
 * Detail Activity that is launched when a list item is clicked.
 * It shows more info on the materi.
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * Initializes the activity, filling in the data from the Intent.
     *
     * @param savedInstanceState Contains information about the saved state
     *                           of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize the views.
        TextView materiTitle = findViewById(R.id.titleDetail);
        TextView materiIsi = findViewById(R.id.IsiDetail);
        ImageView materiImage = findViewById(R.id.materiImageDetail);


        // Set the text from the Intent extra.
        materiTitle.setText(getIntent().getStringExtra("title"));


        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(materiImage);

        materiIsi.setText(getIntent().getStringExtra("isi"));
    }
}
