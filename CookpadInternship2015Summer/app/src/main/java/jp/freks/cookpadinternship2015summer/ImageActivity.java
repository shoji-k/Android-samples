package jp.freks.cookpadinternship2015summer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_ID = "image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        int imageId = intent.getIntExtra(EXTRA_IMAGE_ID, -1);
        Log.d("test", String.valueOf(imageId));

        Button button = (Button) findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageActivity.this, "button clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static Intent createIntent(Activity from, int imageId) {
        Intent intent = new Intent(from, ImageActivity.class);
        intent.putExtra(EXTRA_IMAGE_ID, imageId);
        return intent;
    }
}
