package jp.freks.cookpadinternship2015summer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ImageActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_ID = "image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int imageId = intent.getIntExtra(EXTRA_IMAGE_ID, -1);
        Log.d("test", String.valueOf(imageId));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static Intent createIntent(Activity from, int imageId) {
        Intent intent = new Intent(from, ImageActivity.class);
        intent.putExtra(EXTRA_IMAGE_ID, imageId);
        return intent;
    }
}
