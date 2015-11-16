package jp.freks.cookpadinternship2015summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import jp.freks.cookpadinternship2015summer.model.Image;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.image_list);
        adapter = new ImageAdapter(this);
        adapter.add(new Image(0, "title0", "http://www.xyz..."));
        adapter.add(new Image(1, "title1", "http://www.xyz..."));
        adapter.add(new Image(2, "title2", "http://www.xyz..."));
        listView.setAdapter(adapter);

        Intent intent = ImageActivity.createIntent(this, 100);
        startActivity(intent);

        Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT).show();
    }

}

